package at.adesso.leagueapi.gamedataservice.infrastructure.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    private static final String TESTING_CACHE = "testing-cache";

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("testing");
    }

}
