package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.objectives;


import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.participants.ChampionApiDto;
import lombok.Data;

@Data
public class ObjectivesApiDto {

    private BaronApiDto baron;
    private ChampionApiDto champion;
    private DragonApiDto dragon;
    private InhibitorApiDto inhibitor;
    private RiftHeraldApiDto riftHerald;
    private TowerApiDto tower;

}
