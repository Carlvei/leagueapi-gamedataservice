package at.adesso.leagueapi.gamedataservice.application.summoners;

import at.adesso.leagueapi.commons.errorhandling.exception.ResourceNotFoundException;
import at.adesso.leagueapi.gamedataservice.domain.accounts.model.Summoner;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summoners.RiotSummonerAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SummonerApplicationService {

    private final RiotSummonerAdapter riotSummonerAdapter;

    public Summoner readSummoner(final String name) {
        return riotSummonerAdapter.getSummoner(name)
                .orElseThrow(ResourceNotFoundException::new);
    }

}
