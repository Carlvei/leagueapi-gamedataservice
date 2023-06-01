package at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.participants;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Selection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer perk;
    private Integer var1;
    private Integer var2;
    private Integer var3;

}
