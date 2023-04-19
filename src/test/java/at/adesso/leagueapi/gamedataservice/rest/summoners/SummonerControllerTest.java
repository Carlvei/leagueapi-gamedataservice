package at.adesso.leagueapi.gamedataservice.rest.summoners;

import at.adesso.leagueapi.gamedataservice.rest.AbstractControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(SummonerControllerTest.class)
public class SummonerControllerTest extends AbstractControllerTest {
    // TODO: finish it after good errorhandling
    private static final String API_URL = "/summoners";

    @Test
    void testGetSummoner() throws Exception {

    }

    private MockHttpServletRequestBuilder getSummonerRequestBuilder() {
        return MockMvcRequestBuilders
                .get(API_URL);
    }
}
