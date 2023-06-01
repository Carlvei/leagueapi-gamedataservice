package at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.participants;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Style {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Selection> selections;
    private Integer style;

}
