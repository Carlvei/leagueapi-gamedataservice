package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory;

import at.adesso.leagueapi.gamedataservice.application.matchhistory.model.CompactMatchhistoryEntry;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.facade.mapper.MatchhistoryCompactMapper;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.gameinfo.MatchHistoryEntryWrapper;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.api.RiotMatchhistoryApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RiotMatchhistoryAdapter {

    private final RiotMatchhistoryApi api;
    private final MatchhistoryCompactMapper compactMapper;

    public List<String> queryMatchIds(final String puuid, final int offset, final int limit, final Long startTime) {
        return api.queryMatchIds(puuid, offset, limit, startTime);
    }

    public List<String> queryMatchIds(final String puuid, final int offset, final int limit) {
        return api.queryMatchIds(puuid, offset, limit);
    }

    public Optional<MatchHistoryEntryWrapper> queryMatchhistoryEntryWrapper(final String matchId) {
        return api.queryMatchhistoryEntry(matchId);
    }

    public Optional<CompactMatchhistoryEntry> queryCompactEntry(final String matchId) {
        final Optional<MatchHistoryEntryWrapper> wrapperOptional = api.queryMatchhistoryEntry(matchId);
        if (wrapperOptional.isPresent()) {
            final MatchHistoryEntryWrapper wrapper = wrapperOptional.get();
            return Optional.of(compactMapper.toCompactMatchhistoryEntry(wrapper.getInfo()));
        } else {
            return Optional.empty();
        }
    }
}
