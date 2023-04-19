package at.adesso.leagueapi.gamedataservice.domain.accounts.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Summoner {

    @Id
    private String id;
    private String accountId;
    private Integer profileIconId;
    private Long revisionDate;
    private String name;
    private String puuid;
    private String summonerLevel;
}
