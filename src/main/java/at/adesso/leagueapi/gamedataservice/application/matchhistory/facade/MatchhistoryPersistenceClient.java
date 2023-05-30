package at.adesso.leagueapi.gamedataservice.application.matchhistory.facade;

import at.adesso.leagueapi.commons.errorhandling.exceptions.ResourceNotFoundException;
import at.adesso.leagueapi.gamedataservice.application.matchhistory.mapper.MatchhistoryOverviewMapper;
import at.adesso.leagueapi.gamedataservice.application.summoners.matchhistory.MatchhistoryEntry;
import at.adesso.leagueapi.gamedataservice.application.summoners.matchhistory.MatchhistoryEntryOverview;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.RiotMatchhistoryAdapter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MatchhistoryPersistenceClient implements MatchhistoryPersistenceFacade {

    private final RiotMatchhistoryAdapter matchhistoryAdapter;
    private final MatchhistoryOverviewMapper overviewMapper;

    public MatchhistoryPersistenceClient(final RiotMatchhistoryAdapter matchhistoryAdapter, final MatchhistoryOverviewMapper overviewMapper) {
        this.matchhistoryAdapter = matchhistoryAdapter;
        this.overviewMapper = overviewMapper;
    }

    @Override
    public List<MatchhistoryEntryOverview> getMatchhistoryOverview(final String puuid, final int page, final int limit) {
        final List<String> matchIds = matchhistoryAdapter.queryMatchIds(puuid, convertToOffset(page, limit), limit)
                .orElseThrow(ResourceNotFoundException::new);

        final List<MatchhistoryEntryOverview> entries = new ArrayList<>();
        for (final String matchId : matchIds) {
            final MatchhistoryEntry matchhistoryEntry = matchhistoryAdapter.queryMatchhistoryEntry(matchId)
                    .orElseThrow(ResourceNotFoundException::new);
            entries.add(overviewMapper.toOverview(matchhistoryEntry, puuid));
        }
        return entries;
    }

    private int convertToOffset(final int page, final int limit) {
        return page * limit;
    }
}
