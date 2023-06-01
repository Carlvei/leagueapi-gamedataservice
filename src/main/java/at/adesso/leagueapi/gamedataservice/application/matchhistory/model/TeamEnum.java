package at.adesso.leagueapi.gamedataservice.application.matchhistory.model;

import lombok.Getter;

import java.util.Arrays;

public enum TeamEnum {

    BLUE(100),
    RED(200);

    @Getter
    private final int apiCode;

    TeamEnum(int apiCode) {
        this.apiCode = apiCode;
    }

    public static TeamEnum mapToTeam(final int apiCode) {
        return Arrays.stream(TeamEnum.values())
                .filter(team -> team.getApiCode() == apiCode)
                .findFirst()
                .orElse(null);
    }
}
