package at.adesso.leagueapi.gamedataservice.application.matchhistory.model;

import lombok.Data;

import java.util.List;

@Data
public class MatchhistoryEntryOverview {
    private Long gameCreation;
    private Long gameDuration;
    private String gameMode;
    private CompactParticipant playerData;
    private List<CompactParticipantOverview> participants;
}
