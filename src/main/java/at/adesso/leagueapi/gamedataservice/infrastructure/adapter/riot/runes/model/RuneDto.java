package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.runes.model;

import lombok.Data;

@Data
public class RuneDto {
    private int id;
    private String key;
    private String icon;
    private String name;
}
