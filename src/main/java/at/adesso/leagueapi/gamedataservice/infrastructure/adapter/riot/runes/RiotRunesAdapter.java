package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.runes;

import at.adesso.leagueapi.gamedataservice.domain.runes.RuneTree;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.runes.api.RiotRunesApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RiotRunesAdapter {
    private final RiotRunesApi riotRunesApi;

    public List<RuneTree> queryRunes() {
        return riotRunesApi.queryRunes();
    }
}
