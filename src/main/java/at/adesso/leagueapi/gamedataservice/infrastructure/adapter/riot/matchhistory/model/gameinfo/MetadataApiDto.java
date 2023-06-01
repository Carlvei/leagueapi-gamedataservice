package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.gameinfo;

import lombok.Data;

import java.util.List;

@Data
public class MetadataApiDto {

    private String dataVersion;
    private String matchId;
    private List<String> participants;

}
