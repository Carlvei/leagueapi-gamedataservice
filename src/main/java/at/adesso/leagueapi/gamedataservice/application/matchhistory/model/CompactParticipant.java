package at.adesso.leagueapi.gamedataservice.application.matchhistory.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class CompactParticipant extends CompactParticipantOverview {
    private String puuid;
    private Integer kills;
    private Integer deaths;
    private Integer assists;
    private Integer totalMinionsKilled;
    private Boolean win;
    private Double killParticipation;
    private TeamEnum team;
    private Perks perks;
    private Integer summoner1Id;
    private Integer summoner2Id;
    private List<Item> items;
}

