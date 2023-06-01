package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.participants;

import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.gameinfo.BanApiDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.objectives.ObjectivesApiDto;
import lombok.Data;

import java.util.List;

@Data
public class TeamApiDto {

    private List<BanApiDto> bans;
    private ObjectivesApiDto objectives;
    private Integer teamId;
    private Boolean win;

}
