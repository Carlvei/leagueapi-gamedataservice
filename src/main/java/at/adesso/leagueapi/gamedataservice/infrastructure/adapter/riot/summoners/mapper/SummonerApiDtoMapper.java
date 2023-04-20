package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summoners.mapper;

import at.adesso.leagueapi.commons.mapper.DefaultMapperConfig;
import at.adesso.leagueapi.gamedataservice.domain.accounts.model.Summoner;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summoners.model.SummonerApiDto;
import org.mapstruct.Mapper;

@Mapper(config = DefaultMapperConfig.class)
public interface SummonerApiDtoMapper {
    Summoner toSummoner(SummonerApiDto summonerApiDto);
}
