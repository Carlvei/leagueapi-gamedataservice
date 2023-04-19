package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot;

import at.adesso.leagueapi.gamedataservice.infrastructure.config.resttemplate.model.RiotApiConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public abstract class AbstractRiotAdapter {
    protected final static String HARDCODED_REGION_EUW = "euw";
    protected final static String HARDCODED_REGION_EUROPE = "europe";
    private static final String KEY_HEADER_NAME = "X-Riot-Token";
    private final RiotApiConfigurationProperties properties;
    protected final RestTemplate riotRestTemplate;

    protected AbstractRiotAdapter(final RiotApiConfigurationProperties properties,
                                  final RestTemplate riotRestTemplate) {
        this.properties = properties;
        this.riotRestTemplate = riotRestTemplate;
    }

    protected String getPath(final String region, final String apiName, final String endpointName) {
        return properties.getRegionProperties(region).getApiProperties(apiName).getUrl() + endpointName;
    }

    protected HttpEntity<Void> getHttpEntityWithKeyOnly() {
        return new HttpEntity<>(null, appendKey(new HttpHeaders()));
    }

    protected HttpHeaders appendKey(final HttpHeaders httpHeaders) {
        httpHeaders.set(KEY_HEADER_NAME, properties.getKey());
        return httpHeaders;
    }
}
