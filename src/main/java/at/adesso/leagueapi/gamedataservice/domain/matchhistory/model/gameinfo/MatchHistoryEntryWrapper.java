package at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.gameinfo;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class MatchHistoryEntryWrapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Metadata metadata;

    @OneToOne(cascade = CascadeType.ALL)
    private MatchhistoryEntry info;
}
