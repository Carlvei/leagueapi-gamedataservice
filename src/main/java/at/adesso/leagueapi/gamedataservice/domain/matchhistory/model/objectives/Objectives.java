package at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.objectives;


import at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.participants.Champion;
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
