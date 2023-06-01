package at.adesso.leagueapi.gamedataservice.application.summoners.facade;

import at.adesso.leagueapi.gamedataservice.domain.summoners.model.Summoner;
import at.adesso.leagueapi.gamedataservice.domain.summoners.repository.SummonerRepository;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summoners.api.RiotSummonerApi;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SummonerPersistenceClient implements SummonerPersistenceFacade {
    private final RiotSummonerApi riotSummonerApi;

    private final SummonerRepository summonerRepository;


    public SummonerPersistenceClient(final RiotSummonerApi riotSummonerApi, final SummonerRepository summonerRepository) {
        this.riotSummonerApi = riotSummonerApi;
        this.summonerRepository = summonerRepository;
    }

    public Optional<Summoner> getSummoner(final String name) {
        Optional<Summoner> summoner = summonerRepository.getSummonersByName(name);
        if (summoner.isEmpty()) {
            summoner = riotSummonerApi.getSummoner(name);
            summoner.ifPresent(summonerRepository::save);
        }
        return summoner;

    }
}
