package at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.summoners.mapper;

import at.adesso.leagueapi.commons.mapper.DefaultMapperConfig;
import at.adesso.leagueapi.gamedataservice.application.datadragon.assets.AssetsApplicationService;
import at.adesso.leagueapi.gamedataservice.domain.accounts.model.Summoner;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.summoners.model.SummonerDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(config = DefaultMapperConfig.class)
public abstract class SummonerDtoMapper {

    @Autowired
    protected AssetsApplicationService assetsApplicationService;

    @Mapping(target = "profileIconUrl", ignore = true)
    public abstract SummonerDto toSummonerDto(Summoner summoner);

    @AfterMapping
    protected void resolveSummonerIcon(@MappingTarget final SummonerDto target,
                                       final Summoner source) {
        target.setProfileIconUrl(assetsApplicationService.getProfileIconUrl(source.getProfileIconId()));
    }
}
