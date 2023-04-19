package at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory;

import at.adesso.leagueapi.gamedataservice.application.matchhistory.MatchhistoryApplicationService;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory.mapper.MatchhistoryDtoMapper;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory.model.MatchhistoryEntryOverviewDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matches")
@RequiredArgsConstructor
public class MatchhistoryController {

    private final MatchhistoryDtoMapper mapper;
    private final MatchhistoryApplicationService matchhistoryApplicationService;

    @CrossOrigin // TODO: manage cors
    @GetMapping
    public ResponseEntity<List<MatchhistoryEntryOverviewDto>> getMatchHistoryEntries(@RequestParam final String summonerName) {
        return ResponseEntity
                .ok()
                .body(mapper.toMatchHistoryEntryOverviewListDto(matchhistoryApplicationService.getMatchhistoryOverview(summonerName)));
    }
}
