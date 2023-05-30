package at.adesso.leagueapi.gamedataservice.application.summoners.matchhistory;

import lombok.Data;

import java.util.List;

@Data
public class MatchhistoryEntry {
    private Long gameCreation;
    private Long gameDuration;
    private String gameMode;
    private List<Participant> participants;
}