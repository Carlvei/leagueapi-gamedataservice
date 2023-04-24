package at.adesso.leagueapi.gamedataservice.infrastructure.config.errorhandling.model;

import at.adesso.leagueapi.commons.errorhandling.error.Error;
import at.adesso.leagueapi.commons.errorhandling.exception.ApiException;

import java.util.List;

public class RiotApiException extends ApiException {

    public RiotApiException(final Error error, final String details) {
        super(error, details);
    }

    public RiotApiException(final Error error) {
        super(error);
    }

    public RiotApiException(final String details) {
        super(RiotApiError.RIOT_API_ERROR, details);
    }

    public RiotApiException(final List<String> details) {
        super(RiotApiError.RIOT_API_ERROR, details);
    }
}
