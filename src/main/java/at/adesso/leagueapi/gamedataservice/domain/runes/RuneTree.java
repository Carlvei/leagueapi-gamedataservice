package at.adesso.leagueapi.gamedataservice.domain.runes;

import lombok.Data;

import java.util.List;

@Data
public class RuneTree {
    private int id;
    private String key;
    private String icon;
    private String name;
    private List<RuneSlot> slots;
}
