package at.adesso.leagueapi.gamedataservice.domain.matchhistory.facade.mapper;

import at.adesso.leagueapi.commons.mapper.DefaultMapperConfig;
import at.adesso.leagueapi.gamedataservice.application.matchhistory.model.CompactMatchhistoryEntry;
import at.adesso.leagueapi.gamedataservice.application.matchhistory.model.CompactParticipant;
import at.adesso.leagueapi.gamedataservice.application.matchhistory.model.Item;
import at.adesso.leagueapi.gamedataservice.application.matchhistory.model.TeamEnum;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.gameinfo.MatchhistoryEntry;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.model.participants.Participant;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.ArrayList;
import java.util.List;

@Mapper(config = DefaultMapperConfig.class, imports = TeamEnum.class)
public abstract class MatchhistoryCompactMapper {

    public abstract List<CompactMatchhistoryEntry> toCompactMatchhistoryEntryList(final List<MatchhistoryEntry> entries);

    public abstract CompactMatchhistoryEntry toCompactMatchhistoryEntry(final MatchhistoryEntry entry);

    @Mapping(target = "killParticipation", ignore = true)
    @Mapping(target = "team", expression = "java(TeamEnum.mapToTeam(participant.getTeamId()))")
    @Mapping(target = "items", ignore = true)
    public abstract CompactParticipant toParticipant(Participant participant);

    @AfterMapping
    protected void calculateKillParticipation(@MappingTarget final CompactMatchhistoryEntry target,
                                              final MatchhistoryEntry source) {
        for (final TeamEnum team : TeamEnum.values()) {
            calculateKillParticipation(target.getParticipants().stream()
                    .filter(participant -> participant.getTeam() == team)
                    .toList());
        }
    }

    @AfterMapping
    protected void mapItemsIntoObjectList(@MappingTarget final CompactParticipant target,
                                          final Participant source) {
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

    private void calculateKillParticipation(final List<CompactParticipant> participants) {
        final int totalKills = participants.stream()
                .map(CompactParticipant::getKills)
                .reduce(0, Integer::sum);


        participants.forEach(participant ->
                participant.setKillParticipation(((double) participant.getKills() + (double) participant.getAssists()) / (double) totalKills));
    }
}
