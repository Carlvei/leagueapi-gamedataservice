package at.adesso.leagueapi.gamedataservice.application.summoners;

import at.adesso.leagueapi.commons.errorhandling.exceptions.ResourceNotFoundException;
import at.adesso.leagueapi.gamedataservice.application.summoners.facade.SummonerPersistenceFacade;
import at.adesso.leagueapi.gamedataservice.domain.summoners.model.Summoner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SummonerApplicationService {

    private final SummonerPersistenceFacade summonerPersistenceFacade;


    public Summoner readSummoner(final String name) {
        return summonerPersistenceFacade.getSummoner(name)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
