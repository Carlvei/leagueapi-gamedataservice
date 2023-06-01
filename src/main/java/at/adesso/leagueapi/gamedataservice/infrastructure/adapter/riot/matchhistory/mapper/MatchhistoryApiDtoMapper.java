package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.mapper;

import at.adesso.leagueapi.commons.mapper.DefaultMapperConfig;
import at.adesso.leagueapi.gamedataservice.application.matchhistory.model.TeamEnum;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.gameinfo.Ban;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.gameinfo.MatchHistoryEntryWrapper;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.gameinfo.Metadata;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.objectives.*;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.participants.*;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.gameinfo.BanApiDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.gameinfo.MatchHistoryEntryWrapperApiDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.gameinfo.MatchhistoryEntryApiDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.gameinfo.MetadataApiDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.objectives.*;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.participants.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = DefaultMapperConfig.class, imports = TeamEnum.class)
public abstract class MatchhistoryApiDtoMapper {

    @Mapping(target = "id", ignore = true)
    public abstract MatchHistoryEntryWrapper toMatchHistoryEntryWrapper(final MatchHistoryEntryWrapperApiDto dto);

    @Mapping(target = "id", ignore = true)
    public abstract Challenges toMatchHistoryEntryWrapper(final ChallengesApiDto dto);

    @Mapping(target = "id", ignore = true)
    public abstract Ban toMatchHistoryEntryWrapper(final BanApiDto dto);

    @Mapping(target = "id", ignore = true)
    public abstract Metadata toMatchHistoryEntryWrapper(final MetadataApiDto dto);

    @Mapping(target = "id", ignore = true)
    public abstract Tower toMatchHistoryEntryWrapper(final TowerApiDto dto);

    @Mapping(target = "id", ignore = true)
    public abstract Baron toMatchHistoryEntryWrapper(final BaronApiDto dto);

    @Mapping(target = "id", ignore = true)
    public abstract Dragon toMatchHistoryEntryWrapper(final DragonApiDto dto);

    @Mapping(target = "id", ignore = true)
    public abstract Inhibitor toMatchHistoryEntryWrapper(final InhibitorApiDto dto);

    @Mapping(target = "id", ignore = true)
    public abstract StatPerks toMatchHistoryEntryWrapper(final StatPerksApiDto dto);

    @Mapping(target = "id", ignore = true)
    public abstract RiftHerald toMatchHistoryEntryWrapper(final RiftHeraldApiDto dto);

    @Mapping(target = "id", ignore = true)
    public abstract Champion toMatchHistoryEntryWrapper(final ChampionApiDto dto);

    @Mapping(target = "id", ignore = true)
    public abstract at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.participants.Participant toMatchHistoryEntryWrapper(final ParticipantApiDto dto);

    @Mapping(target = "id", ignore = true)
    public abstract Selection toMatchHistoryEntryWrapper(final SelectionApiDto dto);

    @Mapping(target = "id", ignore = true)
    public abstract Style toMatchHistoryEntryWrapper(final StyleApiDto dto);

    @Mapping(target = "id", ignore = true)
    public abstract Team toMatchHistoryEntryWrapper(final TeamApiDto dto);

    @Mapping(target = "id", ignore = true)
    public abstract Perks toMatchHistoryEntryWrapper(final PerksApiDto dto);

    @Mapping(target = "id", ignore = true)
    public abstract at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.gameinfo.MatchhistoryEntry toMatchhistoryEntry(MatchhistoryEntryApiDto dto);

    @Mapping(target = "id", ignore = true)
    public abstract Objectives toMatchHistoryEntryWrapper(final ObjectivesApiDto dto);


}
