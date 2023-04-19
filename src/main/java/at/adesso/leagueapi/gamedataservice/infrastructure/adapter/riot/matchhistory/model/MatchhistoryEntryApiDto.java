package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model;

import lombok.Data;

import java.util.List;

@Data
public class MatchhistoryEntryApiDto {
    private Long gameCreation;
    private Long gameDuration;
    private String gameMode;
    private List<ParticipantApiDto> participants;
}
