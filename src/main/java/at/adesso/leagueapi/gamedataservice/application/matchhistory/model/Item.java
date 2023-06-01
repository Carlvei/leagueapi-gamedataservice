package at.adesso.leagueapi.gamedataservice.application.matchhistory.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Item {
    private Integer id;
    private Integer itemId;
}
