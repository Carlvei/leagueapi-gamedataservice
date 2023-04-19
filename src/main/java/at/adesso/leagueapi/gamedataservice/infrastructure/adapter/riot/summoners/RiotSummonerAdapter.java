package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summoners;

import at.adesso.leagueapi.gamedataservice.domain.accounts.model.Summoner;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.AbstractRiotAdapter;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summoners.mapper.SummonerApiDtoMapper;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summoners.model.SummonerApiDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.config.resttemplate.model.RiotApiConfigurationProperties;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class RiotSummonerAdapter extends AbstractRiotAdapter {

    private final static String SUMMONER_API_NAME = "summoners";
    private static final String SUMMONERNAME_PATH_PARAMETER_NAME = "summonerName";
    private final SummonerApiDtoMapper apiDtoMapper;

    protected RiotSummonerAdapter(final RiotApiConfigurationProperties properties,
                                  final RestTemplate riotRestTemplate,
                                  final SummonerApiDtoMapper apiDtoMapper) {
        super(properties, riotRestTemplate);
        this.apiDtoMapper = apiDtoMapper;
    }


    public Optional<Summoner> getSummoner(final String name) {
        final String url = getPath(HARDCODED_REGION_EUW, SUMMONER_API_NAME, "by-name/{" + SUMMONERNAME_PATH_PARAMETER_NAME + "}");
        final Map<String, String> pathParams = new LinkedHashMap<>();
        pathParams.put(SUMMONERNAME_PATH_PARAMETER_NAME, name);
        final ResponseEntity<SummonerApiDto> response =
                riotRestTemplate.exchange(url,
                        HttpMethod.GET,
                        getHttpEntityWithKeyOnly(),
                        SummonerApiDto.class,
                        pathParams);
        if (response.getBody() == null || response.getStatusCode() == HttpStatusCode.valueOf(404)) {
            return Optional.empty();
        }
        return Optional.of(apiDtoMapper.toSummoner(response.getBody()));
    }
}
