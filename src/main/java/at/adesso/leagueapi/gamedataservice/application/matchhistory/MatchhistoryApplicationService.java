package at.adesso.leagueapi.gamedataservice.application.matchhistory;

import at.adesso.leagueapi.gamedataservice.application.matchhistory.facade.MatchhistoryPersistenceFacade;
import at.adesso.leagueapi.gamedataservice.application.matchhistory.model.MatchhistoryEntryOverview;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchhistoryApplicationService {


    private final MatchhistoryPersistenceFacade matchhistoryPersistenceFacade;

    public List<MatchhistoryEntryOverview> getMatchhistoryOverview(final String summonerName,
                                                                   final int page,
                                                                   final int limit) {
        return matchhistoryPersistenceFacade.getMatchhistoryOverview(summonerName, page, limit);
    }


}
