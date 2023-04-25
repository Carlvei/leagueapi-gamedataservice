package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summonerspells.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SummonerSpellDto {
    private String name;
    private String id;
    private String key;
}
