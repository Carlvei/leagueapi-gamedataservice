package at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MatchhistoryRequestDto {

    @NotEmpty
    private String summonerName;
}
