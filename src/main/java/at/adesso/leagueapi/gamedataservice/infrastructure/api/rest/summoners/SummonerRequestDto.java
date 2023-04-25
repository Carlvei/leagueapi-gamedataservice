package at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.summoners;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SummonerRequestDto {
    @NotEmpty
    private String summonerName;
}
