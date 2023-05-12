package at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory;

import at.adesso.leagueapi.gamedataservice.application.matchhistory.MatchhistoryApplicationService;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory.mapper.MatchhistoryDtoMapper;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory.model.MatchhistoryEntryOverviewDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matches")
@RequiredArgsConstructor
public class MatchhistoryController implements MatchhistoryApi {

    private final MatchhistoryDtoMapper mapper;
    private final MatchhistoryApplicationService matchhistoryApplicationService;

    @GetMapping
    public ResponseEntity<List<MatchhistoryEntryOverviewDto>> getMatchHistoryEntries(@Valid @RequestParam final String summonerName) {
        return ResponseEntity
                .ok()
                .body(mapper.toMatchHistoryEntryOverviewListDto(matchhistoryApplicationService.getMatchhistoryOverview(summonerName)));
    }
}
