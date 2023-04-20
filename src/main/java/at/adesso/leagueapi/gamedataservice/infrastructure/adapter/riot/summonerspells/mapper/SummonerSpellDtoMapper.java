package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summonerspells.mapper;

import at.adesso.leagueapi.commons.mapper.DefaultMapperConfig;
import at.adesso.leagueapi.gamedataservice.domain.summonerspells.SummonerSpell;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.summonerspells.model.SummonerSpellDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = DefaultMapperConfig.class)
public abstract class SummonerSpellDtoMapper {
    public abstract List<SummonerSpell> toSummonerSpellList(List<SummonerSpellDto> summonerSpellDtos);
}
