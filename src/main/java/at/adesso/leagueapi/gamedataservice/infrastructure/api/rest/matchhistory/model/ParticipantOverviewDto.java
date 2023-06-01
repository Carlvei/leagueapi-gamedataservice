package at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory.model;

import at.adesso.leagueapi.gamedataservice.application.matchhistory.model.TeamEnum;
import lombok.Data;

@Data
public class ParticipantOverviewDto {
    private String championIconUrl;
    private String summonerName;
    private TeamEnum team;
    private String role;
    private String individualPosition;
}
