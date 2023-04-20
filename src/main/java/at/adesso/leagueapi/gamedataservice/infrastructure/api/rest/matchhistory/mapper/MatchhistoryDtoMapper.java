package at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory.mapper;

import at.adesso.leagueapi.commons.errorhandling.exception.ResourceNotFoundException;
import at.adesso.leagueapi.commons.mapper.DefaultMapperConfig;
import at.adesso.leagueapi.gamedataservice.application.datadragon.assets.AssetsApplicationService;
import at.adesso.leagueapi.gamedataservice.application.datadragon.runes.RunesApplicationService;
import at.adesso.leagueapi.gamedataservice.application.datadragon.summonerspells.SummonerSpellApplicationService;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.Item;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.MatchhistoryEntryOverview;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.Participant;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.ParticipantOverview;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory.model.ItemDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory.model.MatchhistoryEntryOverviewDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory.model.ParticipantDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.matchhistory.model.ParticipantOverviewDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(config = DefaultMapperConfig.class)
public abstract class MatchhistoryDtoMapper {
    @Autowired
    private AssetsApplicationService assetsApplicationService;

    @Autowired
    private RunesApplicationService runesApplicationService;

    @Autowired
    private SummonerSpellApplicationService summonerSpellApplicationService;


    public abstract List<MatchhistoryEntryOverviewDto> toMatchHistoryEntryOverviewListDto(List<MatchhistoryEntryOverview> matchhistoryEntryOverview);

    @Mapping(target = "playerData.championIconUrl", ignore = true)
    @Mapping(target = "playerData.primaryRuneUrl", ignore = true)
    @Mapping(target = "playerData.summonerSpellFirstId", ignore = true)
    @Mapping(target = "playerData.summonerSpellSecondId", ignore = true)
    public abstract MatchhistoryEntryOverviewDto toMatchHistoryEntryOverviewListDto(MatchhistoryEntryOverview matchhistoryEntryOverview);

    @Mapping(target = "championIconUrl", ignore = true)
    public abstract ParticipantOverviewDto toParticipantOverviewDto(ParticipantOverview participantOverview);

    @Mapping(target = "itemUrl", ignore = true)
    public abstract ItemDto toItemDto(Item item);

    @AfterMapping
    protected void getChampionIconUrls(@MappingTarget final ParticipantOverviewDto target,
                                       final ParticipantOverview source) {
        target.setChampionIconUrl(assetsApplicationService.getChampionIconUrl(source.getChampionName()));
    }

    @AfterMapping
    protected void getChampionIconUrls(@MappingTarget final ParticipantDto target,
                                       final Participant source) {
        // TODO: find a way without duplication
        target.setChampionIconUrl(assetsApplicationService.getChampionIconUrl(source.getChampionName()));
        target.setPrimaryRuneUrl(runesApplicationService.getRuneIconUrl(source.getPerks().getStyles().stream()
                .filter(styles -> styles.getDescription().equals("primaryStyle"))
                .findFirst()
                .orElseThrow(ResourceNotFoundException::new)
                .getSelections()
                .get(0)
                .getPerk()));
        target.setSummonerSpellFirstId(summonerSpellApplicationService.getSummonerSpellIconUrl(source.getSummoner1Id()));
        target.setSummonerSpellSecondId(summonerSpellApplicationService.getSummonerSpellIconUrl(source.getSummoner2Id()));
    }

    @AfterMapping
    protected void getItemUrl(@MappingTarget final ItemDto target,
                              final Item source) {
        target.setItemUrl(assetsApplicationService.getItemIconUrl(source.getItemId()));
    }
}
