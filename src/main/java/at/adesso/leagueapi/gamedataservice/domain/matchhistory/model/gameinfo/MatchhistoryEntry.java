package at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.gameinfo;

import at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.participants.Participant;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.participants.Team;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class MatchhistoryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long gameCreation;
    private Integer gameDuration;
    private Long gameEndTimestamp;
    private Long gameId;
    private String gameMode;
    private String gameName;
    private Long gameStartTimestamp;
    private String gameType;
    private String gameVersion;
    private Integer mapId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Participant> participants;
    private String platformId;
    private Integer queueId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Team> teams;
    private String tournamentCode;

}
