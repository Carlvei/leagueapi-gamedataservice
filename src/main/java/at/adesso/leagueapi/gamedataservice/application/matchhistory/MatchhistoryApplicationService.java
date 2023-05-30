package at.adesso.leagueapi.gamedataservice.application.matchhistory;

import at.adesso.leagueapi.commons.errorhandling.exceptions.ResourceNotFoundException;
import at.adesso.leagueapi.gamedataservice.application.matchhistory.facade.MatchhistoryPersistenceFacade;
import at.adesso.leagueapi.gamedataservice.application.summoners.matchhistory.MatchhistoryEntryOverview;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summoners.RiotSummonerAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchhistoryApplicationService {


    private final RiotSummonerAdapter summonerAdapter;

    private final MatchhistoryPersistenceFacade matchhistoryPersistenceFacade;

    public List<MatchhistoryEntryOverview> getMatchhistoryOverview(final String summonerName,
                                                                   final int page,
                                                                   final int limit) {
        return matchhistoryPersistenceFacade.getMatchhistoryOverview(getPuuid(summonerName), page, limit);
    }

    private String getPuuid(final String summonerName) {
        return summonerAdapter.getSummoner(summonerName)
                .orElseThrow(ResourceNotFoundException::new)
                .getPuuid();
    }


}
