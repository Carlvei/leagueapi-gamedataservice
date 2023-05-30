package at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory.model;

import at.adesso.leagueapi.gamedataservice.application.summoners.matchhistory.Team;
import lombok.Data;

@Data
public class ParticipantOverviewDto {
    private String championIconUrl;
    private String summonerName;
    private Team team;
    private String role;
    private String individualPosition;
}
