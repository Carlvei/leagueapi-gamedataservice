package at.adesso.leagueapi.gamedataservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

@ActiveProfiles("unittest")
public abstract class AbstractControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    protected RestTemplate restTemplate;
}
