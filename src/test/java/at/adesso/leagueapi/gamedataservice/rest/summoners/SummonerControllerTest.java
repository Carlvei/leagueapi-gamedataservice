package at.adesso.leagueapi.gamedataservice.rest.summoners;

import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summoners.model.SummonerApiDto;
import at.adesso.leagueapi.gamedataservice.rest.AbstractControllerTest;
import at.adesso.leagueapi.testcommons.util.JsonStringToObjectMapper;
import at.adesso.leagueapi.testcommons.util.TestFileUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(SummonerControllerTest.class)
public class SummonerControllerTest extends AbstractControllerTest {

    @MockBean
    private RestTemplate restTemplate;

    // TODO: finish it after good errorhandling
    private static final String API_URL = "/summoners";

    @Test
    @SuppressWarnings("unchecked")
    void testGetSummoner() throws Exception {
        when(restTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(HttpEntity.class), eq(SummonerApiDto.class), any(Map.class)))
                .thenReturn(ResponseEntity
                        .ok()
                        .body(new JsonStringToObjectMapper<>(SummonerApiDto.class)
                                .deserialize(TestFileUtils.readFileAsString("/rest/summoners/summoner.json"))));

        mockMvc.perform(getSummonerRequestBuilder("name"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.profileIconUrl").isNotEmpty())
                .andExpect(jsonPath("$.summonerLevel").value(12))
                .andExpect(jsonPath("$.name").value("SummonerName"));
    }

    private MockHttpServletRequestBuilder getSummonerRequestBuilder(final String name) {
        return MockMvcRequestBuilders
                .get(API_URL + "/" + name);
    }
}
