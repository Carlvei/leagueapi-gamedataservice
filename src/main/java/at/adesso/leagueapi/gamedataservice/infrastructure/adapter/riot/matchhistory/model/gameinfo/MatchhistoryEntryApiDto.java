package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.gameinfo;

import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.participants.ParticipantApiDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.participants.Team;
import lombok.Data;

import java.util.List;

@Data
public class MatchhistoryEntryApiDto {

    public Long gameCreation;
    public Integer gameDuration;
    public Long gameEndTimestamp;
    public Long gameId;
    public String gameMode;
    public String gameName;
    public Long gameStartTimestamp;
    public String gameType;
    public String gameVersion;
    public Integer mapId;
    public List<ParticipantApiDto> participants;
    public String platformId;
    public Integer queueId;
    public List<Team> teams;
    public String tournamentCode;

}
