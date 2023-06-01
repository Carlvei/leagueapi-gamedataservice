package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.participants;

import lombok.Data;

import java.util.List;

@Data
public class PerksApiDto {

    private StatPerksApiDto statPerks;
    private List<StyleApiDto> styles;

}
