package at.adesso.leagueapi.gamedataservice.application.summoners.matchhistory;

import lombok.Data;

import java.util.List;

@Data
public class MatchhistoryEntryOverview {
    private Long gameCreation;
    private Long gameDuration;
    private String gameMode;
    private Participant playerData;
    private List<ParticipantOverview> participants;
}
