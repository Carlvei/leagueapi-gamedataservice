package at.adesso.leagueapi.gamedataservice.domain.matchhistory;

import lombok.Data;

import java.util.List;

@Data
public class Styles {
    private String description;
    private List<Selection> selections;
}
