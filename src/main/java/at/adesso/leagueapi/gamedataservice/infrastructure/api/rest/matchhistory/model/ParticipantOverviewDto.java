package at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory.model;

import at.adesso.leagueapi.gamedataservice.domain.matchhistory.Team;
import lombok.Data;

@Data
public class ParticipantOverviewDto {
    private String championIconUrl;
    private String summonerName;
    private Team team;
    private String role;
    private String individualPosition;
}
