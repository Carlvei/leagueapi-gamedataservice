package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.runes.model;

import lombok.Data;

import java.util.List;

@Data
public class RuneTreeDto {
    private int id;
    private String key;
    private String icon;
    private String name;
    private List<RuneSlotDto> slots;
}
