package at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.summoners;

import at.adesso.leagueapi.gamedataservice.application.summoners.SummonerApplicationService;
import at.adesso.leagueapi.gamedataservice.domain.accounts.model.Summoner;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.summoners.mapper.SummonerDtoMapper;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.summoners.model.SummonerDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.summoners.model.SummonerRequestDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/summoners")
public class SummonerController implements SummonerApi {

    private final SummonerApplicationService summonerApplicationService;

    private final SummonerDtoMapper summonerDtoMapper;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<SummonerDto> getSummoner(@Valid @RequestBody final SummonerRequestDto requestDto) {
        final Summoner summoner = summonerApplicationService.readSummoner(requestDto.getSummonerName());
        return ResponseEntity.
                ok(summonerDtoMapper.toSummonerDto(summoner));
    }
}
