package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.runes.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

import java.util.List;

@Data
public class RunesApiResponseDto {
    @JsonValue
    private List<RuneTreeDto> runeTrees;
}
