package at.adesso.leagueapi.gamedataservice.infrastructure.config.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(value = "riot.api.data-dragon")
@Getter
@Setter
public class DataDragonProperties {
    private Map<String, DataDragonTypeProperties> types;

    public DataDragonTypeProperties getTypeProperties(final String type) {
        return types.get(type);
    }
}
