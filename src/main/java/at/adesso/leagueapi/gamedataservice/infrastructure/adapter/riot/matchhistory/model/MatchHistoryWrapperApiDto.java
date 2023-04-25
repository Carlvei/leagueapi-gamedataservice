package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchHistoryWrapperApiDto {
    private MatchhistoryEntryApiDto info;
}
