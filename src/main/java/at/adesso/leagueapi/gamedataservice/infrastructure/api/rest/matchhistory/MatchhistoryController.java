package at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory;

import at.adesso.leagueapi.gamedataservice.application.matchhistory.MatchhistoryApplicationService;
import at.adesso.leagueapi.gamedataservice.application.matchhistory.model.MatchhistoryEntryOverview;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory.mapper.MatchhistoryDtoMapper;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory.model.MatchhistoryEntryOverviewDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/matches")
@RequiredArgsConstructor
@Validated
@Slf4j
public class MatchhistoryController implements MatchhistoryApi {

    private final MatchhistoryDtoMapper mapper;
    private final MatchhistoryApplicationService matchhistoryApplicationService;

    @GetMapping
    public ResponseEntity<List<MatchhistoryEntryOverviewDto>> getMatchHistoryEntries(@RequestParam final String summonerName,
                                                                                     @RequestParam(required = false, defaultValue = "0") final int page,
                                                                                     @RequestParam(required = false, defaultValue = "10") final int limit) {
        final List<MatchhistoryEntryOverview> overviews = matchhistoryApplicationService.getMatchhistoryOverview(summonerName, page, limit);
        return ResponseEntity
                .ok()
                .body(mapper.toMatchHistoryEntryOverviewListDto(overviews));
    }
}
