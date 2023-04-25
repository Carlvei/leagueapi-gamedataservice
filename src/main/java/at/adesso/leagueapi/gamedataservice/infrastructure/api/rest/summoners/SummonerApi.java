package at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.summoners;

import at.adesso.leagueapi.commons.errorhandling.error.Error;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.summoners.model.SummonerDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.summoners.model.SummonerRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface SummonerApi {

    @Operation(description = "Get the summoner details by summoner name. ", tags = "Summoners",
            responses = {
                    @ApiResponse(
                            description = "Summoner has been fetched successfully.",
                            responseCode = "200",
                            content = {
                                    @Content(mediaType = "application/json",
                                            schema = @Schema(implementation = SummonerDto.class))
                            }),
                    @ApiResponse(
                            description = "No summoner was found.",
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
    ResponseEntity<SummonerDto> getSummoner(SummonerRequestDto requestDto);
}
