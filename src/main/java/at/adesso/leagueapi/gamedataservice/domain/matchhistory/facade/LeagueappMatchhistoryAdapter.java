package at.adesso.leagueapi.gamedataservice.domain.matchhistory.facade;

import at.adesso.leagueapi.gamedataservice.application.matchhistory.facade.model.Gamedata;
import at.adesso.leagueapi.gamedataservice.application.matchhistory.model.CompactMatchhistoryEntry;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.facade.mapper.MatchhistoryCompactMapper;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.facade.repository.MatchhistoryRepository;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.gameinfo.MatchHistoryEntryWrapper;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.gameinfo.MatchhistoryEntry;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LeagueappMatchhistoryAdapter {
    private final MatchhistoryRepository matchhistoryRepository;

    private final MatchhistoryCompactMapper compactMapper;

    public Optional<Gamedata> getLatestGameData(final String summonerName) {
        final Optional<MatchHistoryEntryWrapper> entryOptional =
                matchhistoryRepository.findTopByInfo_Participants_SummonerNameOrderByInfo_GameEndTimestampDesc(summonerName);
        if (entryOptional.isPresent()) {
            final MatchHistoryEntryWrapper entry = entryOptional.get();
            return Optional.of(Gamedata.builder()
                    .summonerName(summonerName)
                    .matchId(entry.getMetadata().getMatchId())
                    .endTime(entry.getInfo().getGameEndTimestamp())
                    .build());
        } else {
            return Optional.empty();
        }
    }

    public List<CompactMatchhistoryEntry> queryCompactEntries(final String summonerName, final int page, final int limit) {
        final List<MatchhistoryEntry> entries = queryEntries(summonerName, page, limit).stream()
                .map(MatchHistoryEntryWrapper::getInfo)
                .toList();
        return compactMapper.toCompactMatchhistoryEntryList(entries);
    }

    public MatchHistoryEntryWrapper save(final MatchHistoryEntryWrapper entry) {
        return matchhistoryRepository.save(entry);
    }

    public boolean isMatchIdSaved(final String matchId) {
        return queryEntry(matchId)
                .isPresent();
    }

    public Optional<MatchHistoryEntryWrapper> queryEntry(final String matchId) {
        return matchhistoryRepository.findByMetadata_MatchId(matchId);
    }

    public List<MatchHistoryEntryWrapper> queryEntries(final String summonerName, final int page, final int limit) {
        return matchhistoryRepository.findByInfo_Participants_SummonerName(summonerName, PageRequest.of(page, limit));
    }
}
