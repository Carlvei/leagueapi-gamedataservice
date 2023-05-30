package at.adesso.leagueapi.gamedataservice.application.summoners.matchhistory;

import lombok.Data;

import java.util.List;

@Data
public class Styles {
    private String description;
    private List<Selection> selections;
}
