package at.adesso.leagueapi.gamedataservice.infrastructure.config.resttemplate;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@Configuration
public class RiotRestTemplateConfig {
    @Bean
    public RestTemplate riotRestTemplate(final RestTemplateBuilder builder) {
        final RestTemplate restTemplate = builder
                .errorHandler(new RestTemplateResponseErrorHandler())
                .build();
        restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }
}
