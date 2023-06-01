package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summonerspells.api;

import at.adesso.leagueapi.gamedataservice.domain.summonerspells.SummonerSpell;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summonerspells.mapper.SummonerSpellDtoMapper;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summonerspells.model.SummonerSpellDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summonerspells.model.SummonerSpellsDataDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summonerspells.model.SummonerSpellsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class RiotSummonerSpellApi {

    private final String summonerSpellsUrl;
    private final RestTemplate restTemplate;
    private final SummonerSpellDtoMapper mapper;

    public RiotSummonerSpellApi(@Value("${riot.api.data-dragon.types.data.subjects.summoner-spells.url}") final String summonerSpellsUrl,
                                final RestTemplate restTemplate, final SummonerSpellDtoMapper mapper) {
        this.summonerSpellsUrl = summonerSpellsUrl;
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }


    public List<SummonerSpell> querySummonerSpells() {
        final ResponseEntity<SummonerSpellsResponse> response =
                restTemplate.exchange(summonerSpellsUrl,
                        HttpMethod.GET,
                        new HttpEntity<>(null, null),
                        SummonerSpellsResponse.class);
        if (response.getBody() == null) {
            return Collections.emptyList();
        }
        return mapper.toSummonerSpellList(extractSummonerSpellsAsList(response.getBody()));
    }

    private List<SummonerSpellDto> extractSummonerSpellsAsList(final SummonerSpellsResponse summonerSpellsResponse) {
        // TODO: For some reason the json is not formatted as a list but as an object with the spells as properties.
        //  But since I will always need to filter the right one I convert it to a list.
        //  Maybe find a solution that won't kill me if stefan sees it.
        final List<SummonerSpellDto> summonerSpellDtos = new ArrayList<>();
        final SummonerSpellsDataDto data = summonerSpellsResponse.getData();
        summonerSpellDtos.add(data.getSummonerBarrier());
        summonerSpellDtos.add(data.getSummonerBoost());
        summonerSpellDtos.add(data.getSummonerDot());
        summonerSpellDtos.add(data.getSummonerExhaust());
        summonerSpellDtos.add(data.getSummonerFlash());
        summonerSpellDtos.add(data.getSummonerHaste());
        summonerSpellDtos.add(data.getSummonerHeal());
        summonerSpellDtos.add(data.getSummonerMana());
        summonerSpellDtos.add(data.getSummonerPoroRecall());
        summonerSpellDtos.add(data.getSummonerPoroThrow());
        summonerSpellDtos.add(data.getSummonerSmite());
        summonerSpellDtos.add(data.getSummonerSnowURFSnowball_Mark());
        summonerSpellDtos.add(data.getSummonerSnowball());
        summonerSpellDtos.add(data.getSummonerTeleport());
        summonerSpellDtos.add(data.getSummoner_UltBookPlaceholder());
        summonerSpellDtos.add(data.getSummoner_UltBookSmitePlaceholder());
        return summonerSpellDtos;
    }
}
