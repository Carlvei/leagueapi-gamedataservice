package at.adesso.leagueapi.gamedataservice.application.datadragon.summonerspells;

import at.adesso.leagueapi.gamedataservice.application.datadragon.AbstractDataDragonApplicationService;
import at.adesso.leagueapi.gamedataservice.domain.summonerspells.SummonerSpell;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summonerspells.RiotSummonerSpellAdapter;
import at.adesso.leagueapi.gamedataservice.infrastructure.config.errorhandling.exception.ResourceNotFoundException;
import at.adesso.leagueapi.gamedataservice.infrastructure.config.model.DataDragonProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummonerSpellApplicationService extends AbstractDataDragonApplicationService {

    private static final String TYPE_NAME = "assets";
    private static final String SUMMONER_SPELLS_SUBJECT_NAME = "summoner-spells";

    private final RiotSummonerSpellAdapter riotSummonerSpellAdapter;

    protected SummonerSpellApplicationService(final DataDragonProperties properties,
                                              final RiotSummonerSpellAdapter riotSummonerSpellAdapter) {
        super(properties);
        this.riotSummonerSpellAdapter = riotSummonerSpellAdapter;
    }

    public String getSummonerSpellIconUrl(final Integer summonerSpellIconKey) {
        return buildUrl(getSummonerSpellId(summonerSpellIconKey));
    }

    private String buildUrl(final String summonerSpellName) {
        return getUrl(TYPE_NAME, SUMMONER_SPELLS_SUBJECT_NAME) + summonerSpellName + ".png";
    }

    private String getSummonerSpellId(final Integer summonerSpellIconKey) {
        return getSummonerSpells().stream()
                .filter(summonerSpell -> summonerSpell.getKey().equals(String.valueOf(summonerSpellIconKey)))
                .findFirst()
                .orElseThrow(ResourceNotFoundException::new)
                .getId();
    }

    private List<SummonerSpell> getSummonerSpells() {
        return riotSummonerSpellAdapter.querySummonerSpells();
    }
}
