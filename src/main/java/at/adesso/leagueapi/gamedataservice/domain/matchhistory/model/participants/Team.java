package at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.participants;

import at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.gameinfo.Ban;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.objectives.Objectives;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Ban> bans;

    @OneToOne(cascade = CascadeType.ALL)
    private Objectives objectives;
    private Integer teamId;
    private Boolean win;

}
