package at.adesso.leagueapi.gamedataservice.infrastructure.config.errorhandling.model;

import lombok.Data;

@Data
public class RiotApiErrorStatus {
    private String message;
    private int status_code;
}
