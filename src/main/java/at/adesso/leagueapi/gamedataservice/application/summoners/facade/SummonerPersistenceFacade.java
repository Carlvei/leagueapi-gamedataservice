package at.adesso.leagueapi.gamedataservice.application.summoners.facade;

import at.adesso.leagueapi.gamedataservice.domain.summoners.model.Summoner;

import java.util.Optional;

public interface SummonerPersistenceFacade {
    Optional<Summoner> getSummoner(String summonerName);
}
