package at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.gameinfo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Metadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataVersion;

    @Column(unique = true)
    private String matchId;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private List<String> participants;

}
