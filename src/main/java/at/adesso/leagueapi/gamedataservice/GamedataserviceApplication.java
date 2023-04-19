package at.adesso.leagueapi.gamedataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("at.adesso.leagueapi")
@EnableConfigurationProperties
@SpringBootApplication
@EnableCaching
public class GamedataserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GamedataserviceApplication.class, args);
    }

}
