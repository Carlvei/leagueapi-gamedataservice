package at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.objectives;


import at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.participants.Champion;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Objectives {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(cascade = CascadeType.ALL)
    private Baron baron;

    @OneToOne(cascade = CascadeType.ALL)
    private Champion champion;

    @OneToOne(cascade = CascadeType.ALL)
    private Dragon dragon;

    @OneToOne(cascade = CascadeType.ALL)
    private Inhibitor inhibitor;

    @OneToOne(cascade = CascadeType.ALL)
    private RiftHerald riftHerald;

    @OneToOne(cascade = CascadeType.ALL)
    private Tower tower;

}
