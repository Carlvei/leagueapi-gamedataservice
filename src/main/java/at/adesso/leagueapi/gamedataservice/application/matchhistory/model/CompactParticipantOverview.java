package at.adesso.leagueapi.gamedataservice.application.matchhistory.model;

import lombok.Data;

@Data
public class CompactParticipantOverview {
    private String championName;
    private String summonerName;
    private TeamEnum team;
    private String role;
    private String individualPosition;
}
