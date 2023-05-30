package at.adesso.leagueapi.gamedataservice.infrastructure.config.resttemplate;

import at.adesso.leagueapi.gamedataservice.infrastructure.config.errorhandling.model.RiotApiException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class RiotRestTemplateConfig {

    private final boolean devMode;

    private final List<String> contexts;

    public RiotRestTemplateConfig(
            @Value("${riot.api.resttemplate.dev-mode:true}") final boolean devMode,
            @Value("${riot.api.resttemplate.rate-limits.contexts}") final List<String> contexts) {
        this.devMode = devMode;
        this.contexts = contexts;
    }

    @Bean
    public RestTemplate riotRestTemplate() {
        final RestTemplate restTemplate = new RestTemplate();

        if (CollectionUtils.isEmpty(contexts)) {
            throw new RiotApiException("Rate limit contexts could not be read.");
        }

        setupErrorHandler(restTemplate);
        setupMessageConverters(restTemplate);
        setupInterceptors(restTemplate);

        return restTemplate;
    }

    private void setupMessageConverters(final RestTemplate restTemplate) {
        restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
    }

    private void setupInterceptors(final RestTemplate restTemplate) {
        List<ClientHttpRequestInterceptor> interceptors =
                restTemplate.getInterceptors();
        if (CollectionUtils.isEmpty(interceptors)) {
            interceptors = new ArrayList<>();
        }
        interceptors.add(new ResttemplateInterceptor(devMode, contexts));
        restTemplate.setInterceptors(interceptors);
    }

    private void setupErrorHandler(final RestTemplate restTemplate) {
        restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
    }
}
