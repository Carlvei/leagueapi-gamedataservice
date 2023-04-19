package at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.summoners.model;

import lombok.Data;

@Data
public class SummonerDto {
    private String profileIconUrl;
    private String name;
    private String summonerLevel;
}
