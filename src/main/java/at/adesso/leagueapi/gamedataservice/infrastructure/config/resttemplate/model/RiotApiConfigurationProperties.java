package at.adesso.leagueapi.gamedataservice.infrastructure.config.resttemplate.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "riot.api")
@Getter
@Setter
public class RiotApiConfigurationProperties {
    private String key;
    private Map<String, RegionConfigurationProperties> regions;

    public RegionConfigurationProperties getRegionProperties(final String region) {
        return regions.get(region);
    }
}
