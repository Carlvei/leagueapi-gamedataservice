package at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.participants;

import lombok.Data;

import java.util.List;

@Data
public class Style {

    public String description;
    public List<Selection> selections;
    public Integer style;

}
