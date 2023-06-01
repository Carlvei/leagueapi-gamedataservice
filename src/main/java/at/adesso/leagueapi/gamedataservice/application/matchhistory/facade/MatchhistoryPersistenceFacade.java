package at.adesso.leagueapi.gamedataservice.application.matchhistory.facade;

import at.adesso.leagueapi.gamedataservice.application.matchhistory.facade.model.Gamedata;
import at.adesso.leagueapi.gamedataservice.application.matchhistory.model.MatchhistoryEntryOverview;

import java.util.List;

public interface MatchhistoryPersistenceFacade {

    /**
     * Queries the {@link List} of {@link MatchhistoryEntryOverview}s for the given parameters.
     * <p>
     * The function works as follows: It first checks if there is {@link Gamedata} stored in the local db. If that is the case
     * the riot api is queried for matches starting from the end of the latest game that is stored in the local db. If any matches
     * are found that are not already saved in the local db, they are imported. After that, the local db is queried with the
     * given parameters, the results are mapped into a {@link List} of {@link MatchhistoryEntryOverview} objects and returned.
     * <p>
     * If there is no gamedata stored in the local db, the riot api is quieried and the results are returned.
     *
     * @param summonerName The name of the summoner to be queried.
     * @param page         The page.
     * @param limit        The maximum number of returned objects.
     * @return A {@link List} of {@link MatchhistoryEntryOverview}s.
     */
    List<MatchhistoryEntryOverview> getMatchhistoryOverview(String summonerName, int page, int limit);

}
