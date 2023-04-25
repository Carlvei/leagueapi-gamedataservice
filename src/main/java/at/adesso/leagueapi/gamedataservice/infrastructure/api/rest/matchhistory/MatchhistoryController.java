package at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory;

import at.adesso.leagueapi.gamedataservice.application.matchhistory.MatchhistoryApplicationService;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory.mapper.MatchhistoryDtoMapper;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory.model.MatchhistoryEntryOverviewDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
@RequiredArgsConstructor
@Validated
public class MatchhistoryController {

    private final MatchhistoryDtoMapper mapper;
    private final MatchhistoryApplicationService matchhistoryApplicationService;

    @CrossOrigin // TODO: manage cors
    @GetMapping
    public ResponseEntity<List<MatchhistoryEntryOverviewDto>> getMatchHistoryEntries(@Valid @RequestBody final MatchhistoryRequestDto requestDto) {
        return ResponseEntity
                .ok()
                .body(mapper.toMatchHistoryEntryOverviewListDto(matchhistoryApplicationService.getMatchhistoryOverview(requestDto.getSummonerName())));
    }
}
