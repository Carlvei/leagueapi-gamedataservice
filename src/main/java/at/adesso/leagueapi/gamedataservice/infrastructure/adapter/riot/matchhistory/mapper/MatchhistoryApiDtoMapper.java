package at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.mapper;

import at.adesso.leagueapi.commons.mapper.DefaultMapperConfig;
import at.adesso.leagueapi.gamedataservice.application.summoners.matchhistory.Item;
import at.adesso.leagueapi.gamedataservice.application.summoners.matchhistory.MatchhistoryEntry;
import at.adesso.leagueapi.gamedataservice.application.summoners.matchhistory.Participant;
import at.adesso.leagueapi.gamedataservice.application.summoners.matchhistory.Team;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.gameinfo.MatchhistoryEntryApiDto;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.matchhistory.model.participants.ParticipantApiDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;
import java.util.List;

@Mapper(config = DefaultMapperConfig.class, imports = Team.class)
public abstract class MatchhistoryApiDtoMapper {
    public abstract MatchhistoryEntry toMatchhistoryEntry(MatchhistoryEntryApiDto dto);

    @Mapping(target = "killParticipation", ignore = true)
    @Mapping(target = "team", expression = "java(Team.mapToTeam(dto.getTeamId()))")
    @Mapping(target = "items", ignore = true)
    public abstract Participant toParticipant(ParticipantApiDto dto);

    @AfterMapping
    protected void calculateKillParticipation(@MappingTarget final MatchhistoryEntry target,
                                              final MatchhistoryEntryApiDto source) {
        for (final Team team : Team.values()) {
            calculateKillParticipation(target.getParticipants().stream()
                    .filter(participant -> participant.getTeam() == team)
                    .toList());
        }
    }

    @AfterMapping
    protected void mapItemsIntoObjectList(@MappingTarget final Participant target,
                                          final ParticipantApiDto source) {
        final List<Item> items = new ArrayList<>();
        items.add(Item.builder()
                .id(0)
                .itemId(source.getItem0())
                .build());
        items.add(Item.builder()
                .id(1)
                .itemId(source.getItem1())
                .build());
        items.add(Item.builder()
                .id(2)
                .itemId(source.getItem2())
                .build());
        items.add(Item.builder()
                .id(3)
                .itemId(source.getItem3())
                .build());
        items.add(Item.builder()
                .id(4)
                .itemId(source.getItem4())
                .build());
        items.add(Item.builder()
                .id(5)
                .itemId(source.getItem5())
                .build());
        items.add(Item.builder()
                .id(6)
                .itemId(source.getItem6())
                .build());
        target.setItems(items);
    }

    private void calculateKillParticipation(final List<Participant> participants) {
        final Long totalKills = participants.stream()
                .map(Participant::getKills)
                .reduce(0L, Long::sum);

        participants.forEach(participant ->
                participant.setKillParticipation(((double) participant.getKills() + (double) participant.getAssists()) / (double) totalKills));
    }


}
