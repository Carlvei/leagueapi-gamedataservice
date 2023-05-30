package at.adesso.leagueapi.gamedataservice.infrastructure.config.resttemplate;

import at.adesso.leagueapi.commons.errorhandling.exceptions.TechnicalException;
import at.adesso.leagueapi.gamedataservice.infrastructure.config.errorhandling.model.RiotApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ResttemplateInterceptor implements ClientHttpRequestInterceptor {

    private final boolean devMode;

    private final List<String> contexts;

    public ResttemplateInterceptor(final boolean devMode, List<String> contexts) {
        this.devMode = devMode;
        this.contexts = contexts;
    }


    @Override
    public ClientHttpResponse intercept(final HttpRequest request,
                                        final byte[] body,
                                        final ClientHttpRequestExecution execution) {
        try {
            final ClientHttpResponse response = execution.execute(request, body);

            if (!response.getStatusCode().isError() && !request.getURI().toString().contains("ddragon")) {
                for (final String context : contexts) {
                    evaluateLimit(response.getHeaders(), context);
                }
            }
            return response;
        } catch (final IOException exception) {
            throw new TechnicalException(exception);
        }
    }

    private void evaluateLimit(final HttpHeaders httpHeaders, final String rateLimitContext) {
        String limitHeader = null;
        String limitCountHeader = null;

        try {
            final List<String> limitHeaders = httpHeaders.get("X-" + rateLimitContext + "-Rate-Limit");
            if (!CollectionUtils.isEmpty(limitHeaders)) {
                limitHeader = limitHeaders.get(0);
            }


            final List<String> limitCountHeaders = httpHeaders.get("X-" + rateLimitContext + "-Rate-Limit-Count");
            if (!CollectionUtils.isEmpty(limitCountHeaders)) {
                limitCountHeader = limitCountHeaders.get(0);
            }

            if (limitHeader == null || limitCountHeader == null) {
                throw new RiotApiException("Limit headers could not be found.");
            }

            final String[] limitHeaderValues = limitHeader.split(",");


            final String[] limitHeaderCountValues = limitCountHeader.split(",");

            if (limitHeaderValues.length != limitHeaderCountValues.length) {
                throw new RiotApiException("Limits and limit counts do not have the same size. Evaluation of limit rates was not possible");
            }
            for (int index = 0; index < limitHeaderValues.length; index++) {
                final int limit = Integer.parseInt(limitHeaderValues[index].split(":")[0]);
                final int count = Integer.parseInt(limitHeaderCountValues[index].split(":")[0]);

                final int limitInterval = Integer.parseInt(limitHeaderValues[index].split(":")[1]);

                if (count >= limit) {
                    if (devMode) {
                        log.trace("Rate limit exceeded. Waiting {} seconds for interval to elapse.", limitInterval);
                        TimeUnit.SECONDS.sleep(limitInterval);
                    } else {
                        throw new RiotApiException("App limit has been exceeded");
                    }
                }
            }
        } catch (final InterruptedException exception) {
            throw new RiotApiException("Error when waiting for interval to elapse");
        }
    }
}
