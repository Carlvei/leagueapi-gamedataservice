package at.adesso.leagueapi.gamedataservice.domain.runes;

import lombok.Data;

@Data
public class Rune {
    private int id;
    private String key;
    private String icon;
    private String name;
}
