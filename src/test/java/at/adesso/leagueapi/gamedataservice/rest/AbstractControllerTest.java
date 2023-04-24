package at.adesso.leagueapi.gamedataservice.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@ActiveProfiles("unittest")
public abstract class AbstractControllerTest {
    @Autowired
    protected MockMvc mockMvc;

}
