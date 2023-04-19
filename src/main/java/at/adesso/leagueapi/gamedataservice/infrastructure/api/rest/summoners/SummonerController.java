package at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.summoners;

import at.adesso.leagueapi.gamedataservice.application.summoners.SummonerApplicationService;
import at.adesso.leagueapi.gamedataservice.domain.accounts.model.Summoner;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.summoners.mapper.SummonerDtoMapper;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.summoners.model.SummonerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/summoners")
public class SummonerController {

    private final SummonerApplicationService summonerApplicationService;

    private final SummonerDtoMapper summonerDtoMapper;

    @CrossOrigin
    @GetMapping("/{name}")
    public ResponseEntity<SummonerDto> getSummoner(@PathVariable final String name) {
        final Summoner summoner = summonerApplicationService.readSummoner(name);
        return ResponseEntity.
                ok(summonerDtoMapper.toSummonerDto(summoner));
    }
}
