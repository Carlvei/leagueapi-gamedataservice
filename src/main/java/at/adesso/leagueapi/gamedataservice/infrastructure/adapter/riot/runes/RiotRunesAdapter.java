package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.runes;

import at.adesso.leagueapi.gamedataservice.domain.runes.RuneTree;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.runes.mapper.RunesDtoMapper;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.runes.model.RuneTreeDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Component
public class RiotRunesAdapter {

    private final String runesJsonUrl;
    private final RestTemplate restTemplate;
    private final RunesDtoMapper mapper;

    public RiotRunesAdapter(@Value("${riot.api.data-dragon.types.data.subjects.runes.url}") final String runesJsonUrl,
                            final RestTemplate restTemplate, final RunesDtoMapper mapper) {
        this.runesJsonUrl = runesJsonUrl;
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }


    public List<RuneTree> queryRunes() {
        final ResponseEntity<List<RuneTreeDto>> response =
                restTemplate.exchange(runesJsonUrl,
                        HttpMethod.GET,
                        new HttpEntity<>(null, null),
                        new ParameterizedTypeReference<>() {
                        });
        if (response.getBody() == null) {
            return Collections.emptyList();
        }
        return mapper.toRunesTreeList(response.getBody());
    }
}
