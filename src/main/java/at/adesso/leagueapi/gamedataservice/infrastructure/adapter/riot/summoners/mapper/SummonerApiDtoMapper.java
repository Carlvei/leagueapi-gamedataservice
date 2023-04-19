package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summoners.mapper;

import at.adesso.leagueapi.gamedataservice.domain.accounts.model.Summoner;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summoners.model.SummonerApiDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.config.mapper.DefaultMapperConfig;
import org.mapstruct.Mapper;

@Mapper(config = DefaultMapperConfig.class)
public interface SummonerApiDtoMapper {
    Summoner toSummoner(SummonerApiDto summonerApiDto);
}
