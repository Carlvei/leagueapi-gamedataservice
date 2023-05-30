package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.participants;

import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.gameinfo.Ban;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.objectives.Objectives;
import lombok.Data;

import java.util.List;

@Data
public class Team {

    public List<Ban> bans;
    public Objectives objectives;
    public Integer teamId;
    public Boolean win;

}
