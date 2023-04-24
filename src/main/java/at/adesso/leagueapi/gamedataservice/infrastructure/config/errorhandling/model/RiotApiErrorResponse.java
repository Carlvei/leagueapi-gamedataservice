package at.adesso.leagueapi.gamedataservice.infrastructure.config.errorhandling.model;

import lombok.Data;

@Data
public class RiotApiErrorResponse {
    private RiotApiErrorStatus status;
}
