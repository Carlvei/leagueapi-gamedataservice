package at.adesso.leagueapi.gamedataservice.application.summoners.matchhistory;

import lombok.Getter;

import java.util.Arrays;

public enum Team {

    BLUE(100),
    RED(200);

    @Getter
    private final int apiCode;

    Team(int apiCode) {
        this.apiCode = apiCode;
    }

    public static Team mapToTeam(final int apiCode) {
        return Arrays.stream(Team.values())
                .filter(team -> team.getApiCode() == apiCode)
                .findFirst()
                .orElse(null);
    }
}
