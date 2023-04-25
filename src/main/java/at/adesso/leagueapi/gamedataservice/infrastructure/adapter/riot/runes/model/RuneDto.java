package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.runes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RuneDto {
    private int id;
    private String key;
    private String icon;
    private String name;
}
