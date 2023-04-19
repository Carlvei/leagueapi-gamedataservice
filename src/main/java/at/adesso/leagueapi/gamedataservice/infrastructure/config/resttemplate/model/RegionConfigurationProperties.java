package at.adesso.leagueapi.gamedataservice.infrastructure.config.resttemplate.model;

import lombok.Data;

import java.util.Map;

@Data
public class RegionConfigurationProperties {
    private String baseUrl;
    private Map<String, ApiProperties> apis;

    public ApiProperties getApiProperties(final String apiName) {
        return apis.get(apiName);
    }
}
