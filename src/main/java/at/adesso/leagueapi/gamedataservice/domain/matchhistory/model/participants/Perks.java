package at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.participants;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Perks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private StatPerks statPerks;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Style> styles;

}
