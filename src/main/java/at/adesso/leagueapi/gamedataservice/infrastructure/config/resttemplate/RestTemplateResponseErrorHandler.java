package at.adesso.leagueapi.gamedataservice.infrastructure.config.resttemplate;

import at.adesso.leagueapi.commons.errorhandling.exception.ResourceNotFoundException;
import at.adesso.leagueapi.commons.errorhandling.exception.TechnicalException;
import at.adesso.leagueapi.commons.mapper.JsonStringToObjectMapper;
import at.adesso.leagueapi.gamedataservice.infrastructure.config.errorhandling.model.RiotApiErrorResponse;
import at.adesso.leagueapi.gamedataservice.infrastructure.config.errorhandling.model.RiotApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(final ClientHttpResponse response) {
        try {
            return response.getStatusCode().isError();
        } catch (final IOException exception) {
            throw new TechnicalException(exception);
        }
    }

    @Override
    public void handleError(final ClientHttpResponse response) {
        int responseCode;
        try {
            responseCode = response.getStatusCode().value();
        } catch (final IOException exception) {
            throw new TechnicalException();
        }
        if (responseCode == HttpStatus.UNAUTHORIZED.value() || responseCode == HttpStatus.FORBIDDEN.value()) {
            handleUnauthorized(response);
        }
        if (responseCode == HttpStatus.NOT_FOUND.value()) {
            handleResourceNotFound();
        }
        if (responseCode == HttpStatus.TOO_MANY_REQUESTS.value()) {
            handleTooManyRequests(response);
        }
        throw new RiotApiException("An error has occured when querying the riot api.");
    }

    private void handleUnauthorized(final ClientHttpResponse response) {
        throw new RiotApiException(generateDetails(response));
    }

    private void handleResourceNotFound() {
        throw new ResourceNotFoundException();

    }

    private void handleTooManyRequests(final ClientHttpResponse response) {
        throw new RiotApiException(generateDetails(response));
    }

    private List<String> generateDetails(final ClientHttpResponse response) {
        try {
            final RiotApiErrorResponse riotApiErrorResponse = new JsonStringToObjectMapper<>(RiotApiErrorResponse.class)
                    .deserialize(new String(response.getBody().readAllBytes(), StandardCharsets.UTF_8));
            return List.of(String.format("Riot api error code: '%s'", response.getStatusCode().value()),
                    String.format("Riot api error message: '%s'", riotApiErrorResponse.getStatus().getMessage()));
        } catch (final IOException exception) {
            throw new TechnicalException(exception);
        }
    }
}
