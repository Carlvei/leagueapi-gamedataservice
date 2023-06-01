package at.adesso.leagueapi.gamedataservice.domain.matchhistory.facade.repository;

import at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.gameinfo.MatchHistoryEntryWrapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchhistoryRepository extends JpaRepository<MatchHistoryEntryWrapper, Long> {

    Optional<MatchHistoryEntryWrapper> findTopByInfo_Participants_SummonerNameOrderByInfo_GameEndTimestampDesc(String summonerName);

    List<MatchHistoryEntryWrapper> findByInfo_Participants_SummonerName(String summonerName, Pageable page);

    Optional<MatchHistoryEntryWrapper> findByMetadata_MatchId(String matchId);
}
