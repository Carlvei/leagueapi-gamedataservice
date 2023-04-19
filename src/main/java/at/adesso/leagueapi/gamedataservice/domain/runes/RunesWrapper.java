package at.adesso.leagueapi.gamedataservice.domain.runes;

import lombok.Data;

import java.util.List;

@Data
public class RunesWrapper {
    private List<RuneTree> runeTrees;
}
