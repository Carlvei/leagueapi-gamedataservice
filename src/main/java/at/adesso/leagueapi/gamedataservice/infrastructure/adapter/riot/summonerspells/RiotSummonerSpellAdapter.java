package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summonerspells;

import at.adesso.leagueapi.gamedataservice.domain.summonerspells.SummonerSpell;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summonerspells.api.RiotSummonerSpellApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RiotSummonerSpellAdapter {
    private final RiotSummonerSpellApi summonerSpellApi;

    public List<SummonerSpell> querySummonerSpells() {
        return summonerSpellApi.querySummonerSpells();
    }
}
