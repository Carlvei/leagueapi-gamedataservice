package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory;

import at.adesso.leagueapi.gamedataservice.application.summoners.matchhistory.MatchhistoryEntry;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.AbstractRiotAdapter;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.mapper.MatchhistoryApiDtoMapper;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.gameinfo.MatchHistoryWrapperApiDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.config.resttemplate.model.RiotApiConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class RiotMatchhistoryAdapter extends AbstractRiotAdapter {

    private static final String MATCHES_API_NAME = "matches";
    private static final String PUUID_PATH_VARIABLE_NAME = "puuid";
    private static final String MATCH_ID_PATH_VARIABLE_NAME = "matchId";
    private static final int DEFAULT_COUNT_VALUE = 20;

    private final RestTemplate restTemplate;

    private final MatchhistoryApiDtoMapper mapper;

    protected RiotMatchhistoryAdapter(final RiotApiConfigurationProperties properties,
                                      final RestTemplate riotRestTemplate,
                                      final RestTemplate restTemplate,
                                      final MatchhistoryApiDtoMapper mapper) {
        super(properties, riotRestTemplate);
        this.restTemplate = restTemplate;
        this.mapper = mapper;
    }

    public Optional<List<String>> queryMatchIds(final String puuid, final int start, final int count) {
        final String url = getPath(HARDCODED_REGION_EUROPE, MATCHES_API_NAME, "by-puuid/{" + PUUID_PATH_VARIABLE_NAME + "}/ids");
        final String urlWithParams = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("start", start)
                .queryParam("count", count == 0 ? 20 : count)
                .build(false)
                .toUriString();
        final Map<String, String> pathParams = new LinkedHashMap<>();
        pathParams.put(PUUID_PATH_VARIABLE_NAME, puuid);
        final ResponseEntity<List<String>> response =
                restTemplate.exchange(urlWithParams,
                        HttpMethod.GET,
                        getHttpEntityWithKeyOnly(),
                        new ParameterizedTypeReference<>() {
                        },
                        pathParams);
        if (response.getBody() == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(response.getBody());
    }

    public Optional<MatchhistoryEntry> queryMatchhistoryEntry(final String matchId) {
        final String url = getPath(HARDCODED_REGION_EUROPE, MATCHES_API_NAME, "{" + MATCH_ID_PATH_VARIABLE_NAME + "}");
        final Map<String, String> pathParams = new LinkedHashMap<>();
        pathParams.put(MATCH_ID_PATH_VARIABLE_NAME, matchId);
        final ResponseEntity<MatchHistoryWrapperApiDto> response =
                restTemplate.exchange(url,
                        HttpMethod.GET,
                        getHttpEntityWithKeyOnly(),
                        MatchHistoryWrapperApiDto.class,
                        pathParams);
        if (response.getBody() == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(mapper.toMatchhistoryEntry(response.getBody().getInfo()));
    }
}
