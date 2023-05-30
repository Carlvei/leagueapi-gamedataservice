package at.adesso.leagueapi.gamedataservice.application.summoners.matchhistory;

import lombok.Data;

@Data
public class ParticipantOverview {
    private String championName;
    private String summonerName;
    private Team team;
    private String role;
    private String individualPosition;
}
