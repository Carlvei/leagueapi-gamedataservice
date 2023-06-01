package at.adesso.leagueapi.gamedataservice.rest.summoners;

import at.adesso.leagueapi.commons.errorhandling.error.CommonError;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summoners.model.SummonerApiDto;
import at.adesso.leagueapi.gamedataservice.rest.AbstractControllerTest;
import at.adesso.leagueapi.testcommons.util.JsonStringToObjectMapper;
import at.adesso.leagueapi.testcommons.util.TestFileUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Disabled
@WebMvcTest(SummonerControllerTest.class)
public class SummonerControllerTest extends AbstractControllerTest {

    // TODO: finish it after good errorhandling
    private static final String API_URL = "/summoners";
    private static final String SUMMONERNAME_REQUEST_PARAM_NAME = "summonerName";

    @Test
    @SuppressWarnings("unchecked")
    void testGetSummonerWithNameIsSuccessful() throws Exception {
        when(restTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(HttpEntity.class), eq(SummonerApiDto.class), any(Map.class)))
                .thenReturn(ResponseEntity
                        .ok()
                        .body(new JsonStringToObjectMapper<>(SummonerApiDto.class)
                                .deserialize(TestFileUtils.readFileAsString("/rest/summoners/summoner.json"))));

        mockMvc.perform(getSummonerWithNameRequestBuilder("name", USER.getAccessToken()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.profileIconUrl").value("https://ddragon.leagueoflegends.com/cdn/testversion/img/profileicon/123.png"))
                .andExpect(jsonPath("$.summonerLevel").value(12))
                .andExpect(jsonPath("$.name").value("SummonerName"));
    }

    @Test
    void testGetSummonerWithEmptyNameResultsInBadRequest() throws Exception {
        mockMvc.perform(getSummonerWithNameRequestBuilder("", USER.getAccessToken()))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(CommonError.VALIDATION_ERROR.getCode()))
                .andExpect(jsonPath("$.message").isNotEmpty())
                .andExpect(jsonPath("$.details").isNotEmpty())
                .andExpect(jsonPath("$.timeStamp").isNotEmpty());
    }

    @Test
    void testGetSummonerWithoutNameResultsInBadRequest() throws Exception {
        mockMvc.perform(getSummonerWithoutNameRequestBuilder(USER.getAccessToken()))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.code").value(CommonError.CLIENT_ERROR.getCode()))
                .andExpect(jsonPath("$.message").isNotEmpty())
                .andExpect(jsonPath("$.details").isNotEmpty())
                .andExpect(jsonPath("$.timeStamp").isNotEmpty());
    }

    private MockHttpServletRequestBuilder getSummonerWithNameRequestBuilder(final String name, final String accessToken) {
        return MockMvcRequestBuilders
                .get(appendRequestParam(API_URL, SUMMONERNAME_REQUEST_PARAM_NAME, name))
                .cookie(getAuthenticationCookie(accessToken));
    }

    private MockHttpServletRequestBuilder getSummonerWithoutNameRequestBuilder(final String accessToken) {
        return MockMvcRequestBuilders
                .get(API_URL)
                .cookie(getAuthenticationCookie(accessToken));
    }
}
