package at.adesso.leagueapi.gamedataservice.application.matchhistory;

import at.adesso.leagueapi.commons.errorhandling.exception.ResourceNotFoundException;
import at.adesso.leagueapi.gamedataservice.application.matchhistory.mapper.MatchhistoryOverviewMapper;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.MatchhistoryEntry;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.MatchhistoryEntryOverview;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.RiotMatchhistoryAdapter;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summoners.RiotSummonerAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchhistoryApplicationService {

    private final RiotMatchhistoryAdapter matchhistoryAdapter;
    private final RiotSummonerAdapter summonerAdapter;
    private final MatchhistoryOverviewMapper overviewMapper;

    @Cacheable("testing")
    public List<MatchhistoryEntryOverview> getMatchhistoryOverview(final String summonerName) {
        final String puuid = getPuuid(summonerName);
        final List<String> matchIds = matchhistoryAdapter.queryMatchIds(puuid, 0, 20)
                .orElseThrow(ResourceNotFoundException::new);

        final List<MatchhistoryEntryOverview> entries = new ArrayList<>();
        for (final String matchId : matchIds) {
            final MatchhistoryEntry matchhistoryEntry = matchhistoryAdapter.queryMatchhistoryEntry(matchId)
                    .orElseThrow(ResourceNotFoundException::new);
            entries.add(overviewMapper.toOverview(matchhistoryEntry, puuid));
        }
        return entries;
    }

    private String getPuuid(final String summonerName) {
        return summonerAdapter.getSummoner(summonerName)
                .orElseThrow(ResourceNotFoundException::new)
                .getPuuid();
    }
}
