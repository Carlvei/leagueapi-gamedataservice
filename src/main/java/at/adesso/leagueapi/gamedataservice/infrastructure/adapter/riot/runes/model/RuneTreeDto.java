package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.runes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RuneTreeDto {
    private int id;
    private String key;
    private String icon;
    private String name;
    private List<RuneSlotDto> slots;
}
