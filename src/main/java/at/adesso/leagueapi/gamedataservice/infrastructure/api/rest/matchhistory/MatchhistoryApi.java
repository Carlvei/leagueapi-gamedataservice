package at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory;

import at.adesso.leagueapi.commons.errorhandling.error.Error;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory.model.MatchhistoryEntryOverviewDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MatchhistoryApi {
    @Operation(description = "Get an overview of match history entries by summoner name. ", tags = "Matchhistory",
            responses = {
                    @ApiResponse(
                            description = "Matchhistory entries have been fetched successfully.",
                            responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = MatchhistoryEntryOverviewDto.class)))
                            }),
                    @ApiResponse(
                            description = "No summoner or matchhistory entries were found.",
                            responseCode = "404",
                            content = {
                                    @Content(mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = Error.class)))
                            }),
                    @ApiResponse(
                            description = "An internal server error occured.",
                            responseCode = "500",
                            content = {
                                    @Content(mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = Error.class)))
                            })
            })
    ResponseEntity<List<MatchhistoryEntryOverviewDto>> getMatchHistoryEntries(@NotEmpty String summonerName);
}
