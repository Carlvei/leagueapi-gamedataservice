package at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.summoners;

import at.adesso.leagueapi.gamedataservice.application.summoners.SummonerApplicationService;
import at.adesso.leagueapi.gamedataservice.domain.accounts.model.Summoner;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.summoners.mapper.SummonerDtoMapper;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.summoners.model.SummonerDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/summoners")
public class SummonerController implements SummonerApi {

    private final SummonerApplicationService summonerApplicationService;

    private final SummonerDtoMapper summonerDtoMapper;

    @GetMapping
    public ResponseEntity<SummonerDto> getSummoner(@Valid @RequestParam final String summonerName) {
        final Summoner summoner = summonerApplicationService.readSummoner(summonerName);
        return ResponseEntity.
                ok(summonerDtoMapper.toSummonerDto(summoner));
    }
}
