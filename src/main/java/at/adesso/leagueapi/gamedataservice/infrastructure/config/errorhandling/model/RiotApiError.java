package at.adesso.leagueapi.gamedataservice.infrastructure.config.errorhandling.model;

import at.adesso.leagueapi.commons.errorhandling.error.Error;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum RiotApiError implements Error {

    RIOT_API_ERROR("ERR-RAPI-001", "The riot api returned an error.", HttpStatus.INTERNAL_SERVER_ERROR, true);

    private final String code;
    private final String message;
    private final HttpStatus defaultHttpStatus;
    private final boolean logged;

    RiotApiError(String code, String message, HttpStatus defaultHttpStatus, boolean logged) {
        this.code = code;
        this.message = message;
        this.defaultHttpStatus = defaultHttpStatus;
        this.logged = logged;
    }
}
