package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.participants;

import lombok.Data;

import java.util.List;

@Data
public class StyleApiDto {

    private String description;
    private List<SelectionApiDto> selections;
    private Integer style;

}
