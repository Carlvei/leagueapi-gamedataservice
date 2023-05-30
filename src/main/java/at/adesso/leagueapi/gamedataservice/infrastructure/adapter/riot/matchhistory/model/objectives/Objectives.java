package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.objectives;


import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.participants.Champion;
import lombok.Data;

@Data
public class Objectives {

    public Baron baron;
    public Champion champion;
    public Dragon dragon;
    public Inhibitor inhibitor;
    public RiftHerald riftHerald;
    public Tower tower;

}
