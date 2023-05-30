package at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.participants;

import at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.gameinfo.Ban;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.objectives.Objectives;
import lombok.Data;

import java.util.List;

@Data
public class Team {

    public List<Ban> bans;
    public Objectives objectives;
    public Integer teamId;
    public Boolean win;

}
