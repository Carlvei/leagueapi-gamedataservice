package at.adesso.leagueapi.gamedataservice.application.matchhistory.facade.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Gamedata {
    private String summonerName;
    private String matchId;
    private Long endTime;
}
