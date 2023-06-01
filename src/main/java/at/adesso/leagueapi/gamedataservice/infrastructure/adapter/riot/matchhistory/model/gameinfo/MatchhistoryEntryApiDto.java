package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.gameinfo;

import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.participants.ParticipantApiDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.participants.TeamApiDto;
import lombok.Data;

import java.util.List;

@Data
public class MatchhistoryEntryApiDto {

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
    private List<ParticipantApiDto> participants;
    private String platformId;
    private Integer queueId;
    private List<TeamApiDto> teams;
    private String tournamentCode;

}
