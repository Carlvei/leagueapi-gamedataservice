package at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.participants;

import lombok.Data;

import java.util.List;

@Data
public class Perks {

    public StatPerks statPerks;
    public List<Style> styles;

}
