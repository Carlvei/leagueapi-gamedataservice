package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summoners;

import at.adesso.leagueapi.gamedataservice.domain.summoners.model.Summoner;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summoners.api.RiotSummonerApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RiotSummonerAdapter {

    private final RiotSummonerApi summonerApi;

    public Optional<Summoner> getSummoner(final String name) {
        return summonerApi.getSummoner(name);
    }
}
