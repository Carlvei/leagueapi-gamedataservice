package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model;

import lombok.Data;

import java.util.List;

@Data
public class PerksDto {
    private List<StylesDto> styles;
}
