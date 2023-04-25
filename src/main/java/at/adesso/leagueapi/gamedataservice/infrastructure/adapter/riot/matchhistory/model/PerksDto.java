package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PerksDto {
    private List<StylesDto> styles;
}
