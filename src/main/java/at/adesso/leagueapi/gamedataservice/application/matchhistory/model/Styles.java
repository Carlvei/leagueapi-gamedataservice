package at.adesso.leagueapi.gamedataservice.application.matchhistory.model;

import lombok.Data;

import java.util.List;

@Data
public class Styles {
    private String description;
    private List<Selection> selections;
}
