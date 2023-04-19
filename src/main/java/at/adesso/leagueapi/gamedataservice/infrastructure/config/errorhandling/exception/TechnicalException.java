package at.adesso.leagueapi.gamedataservice.infrastructure.config.errorhandling.exception;

import at.adesso.leagueapi.gamedataservice.infrastructure.config.errorhandling.error.CommonError;
import at.adesso.leagueapi.gamedataservice.infrastructure.config.errorhandling.error.Error;

public class TechnicalException extends ApiException {
    public TechnicalException(final Error error, final Throwable cause) {
        super(error, cause);
    }

    public TechnicalException(final Throwable cause) {
        super(CommonError.UNKNOWN_SERVER_ERROR, cause);
    }

    public TechnicalException() {
        super(CommonError.UNKNOWN_SERVER_ERROR);
    }
}
