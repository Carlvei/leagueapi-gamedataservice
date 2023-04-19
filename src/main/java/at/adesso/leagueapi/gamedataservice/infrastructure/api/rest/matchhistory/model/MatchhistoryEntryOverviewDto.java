package at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory.model;

import lombok.Data;

import java.util.List;

@Data
public class MatchhistoryEntryOverviewDto {
    private Long gameCreation;
    private Long gameDuration;
    private String gameMode;
    private ParticipantDto playerData;
    private List<ParticipantOverviewDto> participants;
}
