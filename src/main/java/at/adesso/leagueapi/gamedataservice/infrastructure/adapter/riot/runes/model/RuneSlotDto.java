package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.runes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RuneSlotDto {
    private List<RuneDto> runes;
}
