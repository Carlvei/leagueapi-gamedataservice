package at.adesso.leagueapi.gamedataservice.rest;

import at.adesso.leagueapi.commons.domain.Role;
import at.adesso.leagueapi.commons.security.JwtSecurityFilter;
import at.adesso.leagueapi.commons.util.jwt.JwtTokenUtil;
import at.adesso.leagueapi.commons.util.jwt.JwtTokenValidator;
import jakarta.servlet.http.Cookie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ActiveProfiles("unittest")
public abstract class AbstractControllerTest {
    @MockBean
    protected JwtTokenValidator validator;
    @MockBean
    protected JwtTokenUtil util;

    @AllArgsConstructor
    @Getter
    public static class TestUser {
        private String accessToken;
        private String userName;
        private Role role;
    }

    protected final static TestUser USER = new TestUser("eyJhbGciOiJIUzM4NCJ9.eyJ1c2VySWQiOiI1OGUwYTZkNi0wNDAxLTQxMDItODM5NC05NmUzMGIwNmY3NjAiLCJyb2xlIjoiVVNFUiIsImlhdCI6MTY4MzUzMzI4NywiZXhwIjoxNzc4MjI3Njg3fQ.vQIdUDUA8JXEryRgAIl2ndU4EvOK_YfgzZrprPJZXaSKEUU91cJIxran2dS7FBlS",
            "TestUserName",
            Role.USER);

    @Autowired
    protected MockMvc mockMvc;

    @MockBean
    protected RestTemplate restTemplate;

    @BeforeEach
    void setupMocks() {
        when(validator.validateToken(any())).thenReturn(true);
        when(util.getUserIdFromToken(any())).thenReturn(USER.getUserName());
        when(util.getRoleFromToken(any())).thenReturn(USER.getRole().name());
    }

    protected Cookie getAuthenticationCookie(final String accessToken) {
        return new Cookie(JwtSecurityFilter.ACCESS_TOKEN_NAME, accessToken);
    }

    protected String appendRequestParam(final String baseUrl, final String name, final String value) {
        return baseUrl + "?" + name + "=" + value;
    }

}
