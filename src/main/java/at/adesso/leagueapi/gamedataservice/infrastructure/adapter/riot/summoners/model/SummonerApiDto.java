package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summoners.model;

import lombok.Data;

@Data
public class SummonerApiDto {
    private String accountId;
    private Integer profileIconId;
    private Long revisionDate;
    private String name;
    private String id;
    private String puuid;
    private String summonerLevel;
}
