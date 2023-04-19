package at.adesso.leagueapi.gamedataservice.domain.matchhistory;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class Participant extends ParticipantOverview {
    private String puuid;
    private Long kills;
    private Long deaths;
    private Long assists;
    private Long totalMinionsKilled;
    private Boolean win;
    private Double killParticipation;
    private Team team;
    private Perks perks;
    private Integer summoner1Id;
    private Integer summoner2Id;
    private List<Item> items;
}

