package at.adesso.leagueapi.gamedataservice.rest.matchhistory;

import at.adesso.leagueapi.commons.errorhandling.error.CommonError;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.api.RiotMatchhistoryApi;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.gameinfo.MatchHistoryEntryWrapperApiDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.runes.model.RuneTreeDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summoners.model.SummonerApiDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summonerspells.model.SummonerSpellsResponse;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory.MatchhistoryController;
import at.adesso.leagueapi.gamedataservice.rest.AbstractControllerTest;
import at.adesso.leagueapi.testcommons.util.JsonStringToObjectMapper;
import at.adesso.leagueapi.testcommons.util.TestFileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MatchhistoryController.class)
public class MatchhistoryControllerTest extends AbstractControllerTest {

    private static final String API_URL = "/matches";

    private static final String SUMMONERNAME_REQUEST_PARAM_NAME = "summonerName";
    private static final String PAGE_REQUEST_PARAM_NAME = "page";
    private static final String LIMIT_REQUEST_PARAM_NAME = "limit";

    @SpyBean
    private RiotMatchhistoryApi riotMatchhistoryApi;

    @Test
    @SuppressWarnings("unchecked")
    void testGetMatchhistoryWithNameIsSuccessful() throws Exception {
        when(restTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(HttpEntity.class), eq(SummonerApiDto.class), any(Map.class)))
                .thenReturn(ResponseEntity
                        .ok()
                        .body(new JsonStringToObjectMapper<>(SummonerApiDto.class)
                                .deserialize(TestFileUtils.readFileAsString("/rest/summoners/summoner.json"))));

        when(restTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(HttpEntity.class), eq(new ParameterizedTypeReference<List<String>>() {
        }), any(Map.class)))
                .thenReturn(ResponseEntity
                        .ok()
                        .body(new JsonStringToObjectMapper<>(List.class)
                                .deserialize(TestFileUtils.readFileAsString("/rest/matchhistory/match_ids.json"))));

        when(restTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(HttpEntity.class), eq(MatchHistoryEntryWrapperApiDto.class), any(Map.class)))
                .thenReturn(ResponseEntity
                        .ok()
                        .body(new JsonStringToObjectMapper<>(MatchHistoryEntryWrapperApiDto.class)
                                .deserialize(TestFileUtils.readFileAsString("/rest/matchhistory/matchhistoryentry.json"))));

        when(restTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(HttpEntity.class), eq(new ParameterizedTypeReference<List<RuneTreeDto>>() {
        })))
                .thenReturn(ResponseEntity
                        .ok()
                        .body(List.of(new JsonStringToObjectMapper<>(RuneTreeDto.class)
                                .deserialize(TestFileUtils.readFileAsString("/rest/runes/runes.json")))));

        when(restTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(HttpEntity.class), eq(SummonerSpellsResponse.class)))
                .thenReturn(ResponseEntity
                        .ok()
                        .body(new JsonStringToObjectMapper<>(SummonerSpellsResponse.class)
                                .deserialize(TestFileUtils.readFileAsString("/rest/summonerspells/summonerspells.json"))));

        mockMvc.perform(getMatchhistoryWithNameRequestBuilder("SummonerName1", USER.getAccessToken()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].gameCreation").isNotEmpty())
                .andExpect(jsonPath("$[0].gameDuration").isNotEmpty())
                .andExpect(jsonPath("$[0].gameMode").value("ARAM"))
                .andExpect(jsonPath("$[0].playerData.championIconUrl").value("https://ddragon.leagueoflegends.com/cdn/testversion/img/champion/MasterYi.png"))
                .andExpect(jsonPath("$[0].playerData.summonerName").value("SummonerName1"))
                .andExpect(jsonPath("$[0].playerData.team").value("BLUE"))
                .andExpect(jsonPath("$[0].playerData.role").value("SUPPORT"))
                .andExpect(jsonPath("$[0].playerData.individualPosition").value("Invalid"))
                .andExpect(jsonPath("$[0].playerData.kills").value(35))
                .andExpect(jsonPath("$[0].playerData.deaths").value(18))
                .andExpect(jsonPath("$[0].playerData.assists").value(19))
                .andExpect(jsonPath("$[0].playerData.totalMinionsKilled").value(32))
                .andExpect(jsonPath("$[0].playerData.win").value(true))
                .andExpect(jsonPath("$[0].playerData.killParticipation").value(0.627906976744186))
                .andExpect(jsonPath("$[0].playerData.primaryRuneUrl").value("https://ddragon.leagueoflegends.com/cdn/img/perk-images/Styles/Domination/DarkHarvest/DarkHarvest.png"))
                .andExpect(jsonPath("$[0].playerData.summonerSpellFirstId").value("https://ddragon.leagueoflegends.com/cdn/testversion/img/spell/SummonerFlash.png"))
                .andExpect(jsonPath("$[0].playerData.summonerSpellSecondId").value("https://ddragon.leagueoflegends.com/cdn/testversion/img/spell/SummonerHaste.png"))
                .andExpect(jsonPath("$[0].playerData.items", hasSize(7)))
                .andExpect(jsonPath("$[0].participants", hasSize(10)))
                .andExpect(jsonPath("$[0].participants[1].championIconUrl").value("https://ddragon.leagueoflegends.com/cdn/testversion/img/champion/Sejuani.png"))
                .andExpect(jsonPath("$[0].participants[1].summonerName").value("SummonerName2"))
                .andExpect(jsonPath("$[0].participants[1].team").value("BLUE"))
                .andExpect(jsonPath("$[0].participants[1].role").value("CARRY"))
                .andExpect(jsonPath("$[0].participants[1].individualPosition").value("Invalid"))
                .andExpect(jsonPath("$[0].participants[8].championIconUrl").value("https://ddragon.leagueoflegends.com/cdn/testversion/img/champion/Zac.png"))
                .andExpect(jsonPath("$[0].participants[8].summonerName").value("SummonerName10"))
                .andExpect(jsonPath("$[0].participants[8].team").value("RED"))
                .andExpect(jsonPath("$[0].participants[8].role").value("SUPPORT"))
                .andExpect(jsonPath("$[0].participants[8].individualPosition").value("Invalid"));

        verify(riotMatchhistoryApi, times(1)).queryMatchIds("puuid", 0, 20, null);
    }

    @Test
    @SuppressWarnings("unchecked")
    void testGetMatchhistoryWithNamePageAndLimitResultsInCorrectCallIsSuccessful() throws Exception {
        when(restTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(HttpEntity.class), eq(SummonerApiDto.class), any(Map.class)))
                .thenReturn(ResponseEntity
                        .ok()
                        .body(new JsonStringToObjectMapper<>(SummonerApiDto.class)
                                .deserialize(TestFileUtils.readFileAsString("/rest/summoners/summoner.json"))));

        when(restTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(HttpEntity.class), eq(new ParameterizedTypeReference<List<String>>() {
        }), any(Map.class)))
                .thenReturn(ResponseEntity
                        .ok()
                        .body(new JsonStringToObjectMapper<>(List.class)
                                .deserialize(TestFileUtils.readFileAsString("/rest/matchhistory/match_ids.json"))));

        when(restTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(HttpEntity.class), eq(MatchHistoryEntryWrapperApiDto.class), any(Map.class)))
                .thenReturn(ResponseEntity
                        .ok()
                        .body(new JsonStringToObjectMapper<>(MatchHistoryEntryWrapperApiDto.class)
                                .deserialize(TestFileUtils.readFileAsString("/rest/matchhistory/matchhistoryentry.json"))));

        when(restTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(HttpEntity.class), eq(new ParameterizedTypeReference<List<RuneTreeDto>>() {
        })))
                .thenReturn(ResponseEntity
                        .ok()
                        .body(List.of(new JsonStringToObjectMapper<>(RuneTreeDto.class)
                                .deserialize(TestFileUtils.readFileAsString("/rest/runes/runes.json")))));

        when(restTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(HttpEntity.class), eq(SummonerSpellsResponse.class)))
                .thenReturn(ResponseEntity
                        .ok()
                        .body(new JsonStringToObjectMapper<>(SummonerSpellsResponse.class)
                                .deserialize(TestFileUtils.readFileAsString("/rest/summonerspells/summonerspells.json"))));

        mockMvc.perform(getMatchhistoryWithNamePageAndLimitRequestBuilder("SummonerName1", 2, 20, USER.getAccessToken()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));

        verify(riotMatchhistoryApi, times(1)).queryMatchIds("puuid", 40, 20, null);
    }

    @Test
    void testGetMatchhistoryWithoutNameResultsInBadRequest() throws Exception {
        mockMvc.perform(getMatchhistoryWithoutNameRequestBuilder(USER.getAccessToken()))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(CommonError.CLIENT_ERROR.getCode()))
                .andExpect(jsonPath("$.message").isNotEmpty())
                .andExpect(jsonPath("$.details").isNotEmpty())
                .andExpect(jsonPath("$.timeStamp").isNotEmpty());
    }

    @Test
    void testGetMatchhistoryWithEmptyNameResultsInBadRequest() throws Exception {
        mockMvc.perform(getMatchhistoryWithNameRequestBuilder("", USER.getAccessToken()))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(CommonError.VALIDATION_ERROR.getCode()))
                .andExpect(jsonPath("$.message").isNotEmpty())
                .andExpect(jsonPath("$.details").isNotEmpty())
                .andExpect(jsonPath("$.timeStamp").isNotEmpty());
    }

    private MockHttpServletRequestBuilder getMatchhistoryWithNameRequestBuilder(final String name, final String accessToken) {
        return MockMvcRequestBuilders
                .get(appendRequestParam(API_URL, SUMMONERNAME_REQUEST_PARAM_NAME, name))
                .cookie(getAuthenticationCookie(accessToken));
    }

    private MockHttpServletRequestBuilder getMatchhistoryWithNamePageAndLimitRequestBuilder(final String name, final int page, final int limit, final String accessToken) {
        final Map<String, String> requestParams = new LinkedHashMap<>();
        requestParams.put(SUMMONERNAME_REQUEST_PARAM_NAME, name);
        requestParams.put(PAGE_REQUEST_PARAM_NAME, String.valueOf(page));
        requestParams.put(LIMIT_REQUEST_PARAM_NAME, String.valueOf(limit));
        return MockMvcRequestBuilders
                .get(appendRequestParams(API_URL, requestParams))
                .cookie(getAuthenticationCookie(accessToken));
    }

    private MockHttpServletRequestBuilder getMatchhistoryWithoutNameRequestBuilder(final String accessToken) {
        return MockMvcRequestBuilders
                .get(API_URL)
                .cookie(getAuthenticationCookie(accessToken));
    }
}
