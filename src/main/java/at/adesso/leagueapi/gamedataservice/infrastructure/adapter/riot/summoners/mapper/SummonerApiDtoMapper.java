package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summoners.mapper;

import at.adesso.leagueapi.commons.mapper.DefaultMapperConfig;
import at.adesso.leagueapi.gamedataservice.domain.summoners.model.Summoner;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summoners.model.SummonerApiDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = DefaultMapperConfig.class)
public interface SummonerApiDtoMapper {
    @Mapping(target = "summonerId", source = "id")
    @Mapping(target = "id", ignore = true)
    Summoner toSummoner(SummonerApiDto summonerApiDto);
}
