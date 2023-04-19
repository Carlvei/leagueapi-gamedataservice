package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.runes.mapper;

import at.adesso.leagueapi.gamedataservice.domain.runes.RuneTree;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.runes.model.RuneTreeDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.config.mapper.DefaultMapperConfig;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = DefaultMapperConfig.class)
public interface RunesDtoMapper {
    List<RuneTree> toRunesTreeList(List<RuneTreeDto> dto);
}
