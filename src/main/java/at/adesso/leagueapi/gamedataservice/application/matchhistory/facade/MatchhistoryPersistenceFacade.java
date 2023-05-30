package at.adesso.leagueapi.gamedataservice.application.matchhistory.facade;

import at.adesso.leagueapi.gamedataservice.application.summoners.matchhistory.MatchhistoryEntryOverview;

import java.util.List;

public interface MatchhistoryPersistenceFacade {

    List<MatchhistoryEntryOverview> getMatchhistoryOverview(String puuid, int page, int limit);

}
