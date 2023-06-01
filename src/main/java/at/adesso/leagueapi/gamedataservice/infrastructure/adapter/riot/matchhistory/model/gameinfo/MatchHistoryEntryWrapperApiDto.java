package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.gameinfo;

import lombok.Data;

@Data
public class MatchHistoryEntryWrapperApiDto {

    private MetadataApiDto metadata;
    private MatchhistoryEntryApiDto info;

}
