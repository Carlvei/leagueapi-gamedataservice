package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.gameinfo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Metadata {

    public String dataVersion;
    public String matchId;
    public List<String> participants;

}
