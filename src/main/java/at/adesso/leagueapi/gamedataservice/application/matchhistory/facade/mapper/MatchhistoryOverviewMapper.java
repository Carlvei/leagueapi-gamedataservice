package at.adesso.leagueapi.gamedataservice.application.matchhistory.facade.mapper;

import at.adesso.leagueapi.commons.errorhandling.exceptions.ResourceNotFoundException;
import at.adesso.leagueapi.commons.mapper.DefaultMapperConfig;
import at.adesso.leagueapi.gamedataservice.application.matchhistory.model.CompactMatchhistoryEntry;
import at.adesso.leagueapi.gamedataservice.application.matchhistory.model.CompactParticipant;
import at.adesso.leagueapi.gamedataservice.application.matchhistory.model.MatchhistoryEntryOverview;
import org.mapstruct.*;

import java.util.List;

@Mapper(config = DefaultMapperConfig.class)
public abstract class MatchhistoryOverviewMapper {

    public abstract List<MatchhistoryEntryOverview> toOverviewList(final List<CompactMatchhistoryEntry> matchhistoryEntries, @Context final String puuid);

    @Mapping(target = "playerData", ignore = true)
    public abstract MatchhistoryEntryOverview toOverview(final CompactMatchhistoryEntry compactMatchhistoryEntry, @Context final String puuid);

    @AfterMapping
    protected void updateSummonerSpecificValues(@MappingTarget final MatchhistoryEntryOverview target,
                                                @Context final String puuid,
                                                final CompactMatchhistoryEntry source) {
        final CompactParticipant summonerData = source.getParticipants().stream()
                .filter(participant -> participant.getPuuid().equals(puuid))
                .findFirst()
                .orElseThrow(ResourceNotFoundException::new);

        target.setPlayerData(summonerData);
    }
}
