package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.api;

import at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.gameinfo.MatchHistoryEntryWrapper;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.AbstractRiotAdapter;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.mapper.MatchhistoryApiDtoMapper;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.gameinfo.MatchHistoryEntryWrapperApiDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.config.resttemplate.model.RiotApiConfigurationProperties;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;

@Component
public class RiotMatchhistoryApi extends AbstractRiotAdapter {

    private static final String MATCHES_API_NAME = "matches";
    private static final String PUUID_PATH_VARIABLE_NAME = "puuid";
    private static final String MATCH_ID_PATH_VARIABLE_NAME = "matchId";
    private final MatchhistoryApiDtoMapper apiDtoMapper;
    private final RestTemplate restTemplate;

    protected RiotMatchhistoryApi(final RiotApiConfigurationProperties properties,
                                  final RestTemplate riotRestTemplate,
                                  MatchhistoryApiDtoMapper apiDtoMapper, final RestTemplate restTemplate) {
        super(properties, riotRestTemplate);
        this.apiDtoMapper = apiDtoMapper;
        this.restTemplate = restTemplate;
    }

    public List<String> queryMatchIds(final String puuid, final int offset, final int limit, final Long startTime) {
        final String url = getPath(HARDCODED_REGION_EUROPE, MATCHES_API_NAME, "by-puuid/{" + PUUID_PATH_VARIABLE_NAME + "}/ids");
        final String urlWithParams = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("start", offset)
                .queryParam("count", limit == 0 ? 20 : limit)
                .queryParam("startTime", startTime)
                .build(false)
                .toUriString();
        return queryMatchIds(puuid, urlWithParams);
    }

    public List<String> queryMatchIds(final String puuid, final int offset, final int limit) {
        final String url = getPath(HARDCODED_REGION_EUROPE, MATCHES_API_NAME, "by-puuid/{" + PUUID_PATH_VARIABLE_NAME + "}/ids");
        final String urlWithParams = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("start", offset)
                .queryParam("count", limit == 0 ? 20 : limit)
                .build(false)
                .toUriString();
        return queryMatchIds(puuid, urlWithParams);
    }

    private List<String> queryMatchIds(final String puuid, final String urlWithParams) {
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
            return Collections.emptyList();
        }
        return response.getBody();
    }

    public Optional<MatchHistoryEntryWrapper> queryMatchhistoryEntry(final String matchId) {
        System.out.println("Sending request");
        final String url = getPath(HARDCODED_REGION_EUROPE, MATCHES_API_NAME, "{" + MATCH_ID_PATH_VARIABLE_NAME + "}");
        final Map<String, String> pathParams = new LinkedHashMap<>();
        pathParams.put(MATCH_ID_PATH_VARIABLE_NAME, matchId);
        final ResponseEntity<MatchHistoryEntryWrapperApiDto> response =
                restTemplate.exchange(url,
                        HttpMethod.GET,
                        getHttpEntityWithKeyOnly(),
                        MatchHistoryEntryWrapperApiDto.class,
                        pathParams);
        if (response.getBody() == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(apiDtoMapper.toMatchHistoryEntryWrapper(response.getBody()));
    }
}
