package at.adesso.leagueapi.gamedataservice.domain.summoners.repository;

import at.adesso.leagueapi.gamedataservice.domain.summoners.model.Summoner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SummonerRepository extends JpaRepository<Summoner, Long> {
    Optional<Summoner> getSummonersByName(final String name);
}
