package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summonerspells.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SummonerSpellsDataDto {
    @JsonProperty(value = "SummonerBarrier")
    private SummonerSpellDto summonerBarrier;

    @JsonProperty(value = "SummonerBoost")
    private SummonerSpellDto summonerBoost;

    @JsonProperty(value = "SummonerDot")
    private SummonerSpellDto summonerDot;

    @JsonProperty(value = "SummonerExhaust")
    private SummonerSpellDto summonerExhaust;

    @JsonProperty(value = "SummonerFlash")
    private SummonerSpellDto summonerFlash;

    @JsonProperty(value = "SummonerHaste")
    private SummonerSpellDto summonerHaste;

    @JsonProperty(value = "SummonerHeal")
    private SummonerSpellDto summonerHeal;

    @JsonProperty(value = "SummonerMana")
    private SummonerSpellDto summonerMana;

    @JsonProperty(value = "SummonerPoroRecall")
    private SummonerSpellDto summonerPoroRecall;

    @JsonProperty(value = "SummonerPoroThrow")
    private SummonerSpellDto summonerPoroThrow;

    @JsonProperty(value = "SummonerSmite")
    private SummonerSpellDto summonerSmite;

    @JsonProperty(value = "SummonerSnowURFSnowball_Mark")
    private SummonerSpellDto summonerSnowURFSnowball_Mark;

    @JsonProperty(value = "SummonerSnowball")
    private SummonerSpellDto summonerSnowball;

    @JsonProperty(value = "SummonerTeleport")
    private SummonerSpellDto summonerTeleport;

    @JsonProperty(value = "Summoner_UltBookPlaceholder")
    private SummonerSpellDto summoner_UltBookPlaceholder;

    @JsonProperty(value = "Summoner_UltBookSmitePlaceholder")
    private SummonerSpellDto summoner_UltBookSmitePlaceholder;
}
