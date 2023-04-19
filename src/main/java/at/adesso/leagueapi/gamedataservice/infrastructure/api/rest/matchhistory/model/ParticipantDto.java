package at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ParticipantDto extends ParticipantOverviewDto {
    private Long kills;
    private Long deaths;
    private Long assists;
    private Long totalMinionsKilled;
    private Boolean win;
    private Double killParticipation;
    private String primaryRuneUrl;
    private String summonerSpellFirstId;
    private String summonerSpellSecondId;
    private List<ItemDto> items;
}
