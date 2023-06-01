package at.adesso.leagueapi.gamedataservice.application.matchhistory.model;

import lombok.Data;

import java.util.List;

@Data
public class CompactMatchhistoryEntry {
    private Long gameCreation;
    private Long gameDuration;
    private String gameMode;
    private List<CompactParticipant> participants;
}
