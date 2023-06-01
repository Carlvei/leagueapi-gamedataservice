package at.adesso.leagueapi.gamedataservice.application.matchhistory.facade;

import at.adesso.leagueapi.commons.errorhandling.exceptions.ResourceNotFoundException;
import at.adesso.leagueapi.gamedataservice.application.matchhistory.facade.mapper.MatchhistoryOverviewMapper;
import at.adesso.leagueapi.gamedataservice.application.matchhistory.facade.model.Gamedata;
import at.adesso.leagueapi.gamedataservice.application.matchhistory.model.CompactMatchhistoryEntry;
import at.adesso.leagueapi.gamedataservice.application.matchhistory.model.MatchhistoryEntryOverview;
import at.adesso.leagueapi.gamedataservice.application.summoners.facade.SummonerPersistenceFacade;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.facade.LeagueappMatchhistoryAdapter;
import at.adesso.leagueapi.gamedataservice.domain.summoners.model.Summoner;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.RiotMatchhistoryAdapter;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summoners.RiotSummonerAdapter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class MatchhistoryPersistenceClient implements MatchhistoryPersistenceFacade {

    private final RiotMatchhistoryAdapter riotMatchhistoryAdapter;
    private final MatchhistoryOverviewMapper overviewMapper;
    private final RiotSummonerAdapter summonerAdapter;
    private final SummonerPersistenceFacade summonerPersistenceFacade;
    private final LeagueappMatchhistoryAdapter leagueappMatchhistoryAdapter;


    @Override
    public List<MatchhistoryEntryOverview> getMatchhistoryOverview(final String summonerName, final int page, final int limit) {
        final List<MatchhistoryEntryOverview> entries = new ArrayList<>();
        final String puuid = getPuuid(summonerName);
        final Optional<Gamedata> gamedataOptional = leagueappMatchhistoryAdapter.getLatestGameData(summonerName);
        if (gamedataOptional.isPresent()) {
            final Gamedata gamedata = gamedataOptional.get();
            final List<String> matchIds = riotMatchhistoryAdapter.queryMatchIds(puuid, 0, 50, gamedata.getEndTime());
            if (!CollectionUtils.isEmpty(matchIds)) {
                for (final String matchId : matchIds) {
                    if (!leagueappMatchhistoryAdapter.isMatchIdSaved(matchId)) {
                        riotMatchhistoryAdapter.queryMatchhistoryEntryWrapper(matchId)
                                .ifPresent(leagueappMatchhistoryAdapter::save);
                    }
                }
            }
            final List<CompactMatchhistoryEntry> matchhistoryEntries = leagueappMatchhistoryAdapter.queryCompactEntries(summonerName, page, limit);
            return overviewMapper.toOverviewList(matchhistoryEntries, puuid);
        } else {
            final List<String> matchIds = riotMatchhistoryAdapter.queryMatchIds(puuid, convertToOffset(page, limit), limit);
            for (final String matchId : matchIds) {
                final CompactMatchhistoryEntry compactMatchhistoryEntry = riotMatchhistoryAdapter.queryCompactEntry(matchId)
                        .orElseThrow(ResourceNotFoundException::new);
                entries.add(overviewMapper.toOverview(compactMatchhistoryEntry, summonerName));
            }
            return entries;
        }
    }

    private int convertToOffset(final int page, final int limit) {
        return page * limit;
    }

    private String getPuuid(final String summonerName) {
        return summonerAdapter.getSummoner(summonerName)
                .orElseThrow(ResourceNotFoundException::new)
                .getPuuid();
    }

    private Summoner getSummoner(final String summonerName) {
        return summonerPersistenceFacade.getSummoner(summonerName)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
