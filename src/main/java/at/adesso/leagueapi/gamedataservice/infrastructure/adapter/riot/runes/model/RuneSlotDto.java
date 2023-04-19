package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.runes.model;

import lombok.Data;

import java.util.List;

@Data
public class RuneSlotDto {
    private List<RuneDto> runes;
}
