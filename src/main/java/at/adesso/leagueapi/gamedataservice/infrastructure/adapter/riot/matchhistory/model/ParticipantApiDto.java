package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ParticipantApiDto {
    private String championName;
    private String puuid;
    private String summonerName;
    private String role;
    private String individualPosition;
    private Long kills;
    private Long deaths;
    private Long assists;
    private Long totalMinionsKilled;
    private Boolean win;
    private Integer teamId;
    private Integer profileIcon;
    private PerksDto perks;
    private Integer summoner1Id;
    private Integer summoner2Id;
    private Integer item0;
    private Integer item1;
    private Integer item2;
    private Integer item3;
    private Integer item4;
    private Integer item5;
    private Integer item6;
}

