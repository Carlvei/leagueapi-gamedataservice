package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.gameinfo;

import lombok.Data;

@Data
public class MatchHistoryWrapperApiDto {

    public Metadata metadata;
    public MatchhistoryEntryApiDto info;

}
