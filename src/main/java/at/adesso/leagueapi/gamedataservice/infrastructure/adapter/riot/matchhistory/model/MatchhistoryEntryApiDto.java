package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchhistoryEntryApiDto {
    private Long gameCreation;
    private Long gameDuration;
    private String gameMode;
    private List<ParticipantApiDto> participants;
}
