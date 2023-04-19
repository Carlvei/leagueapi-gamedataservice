package at.adesso.leagueapi.gamedataservice.application.matchhistory.mapper;

import at.adesso.leagueapi.gamedataservice.domain.matchhistory.MatchhistoryEntry;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.MatchhistoryEntryOverview;
import at.adesso.leagueapi.gamedataservice.domain.matchhistory.Participant;
import at.adesso.leagueapi.gamedataservice.infrastructure.config.errorhandling.exception.ResourceNotFoundException;
import at.adesso.leagueapi.gamedataservice.infrastructure.config.mapper.DefaultMapperConfig;
import org.mapstruct.*;

@Mapper(config = DefaultMapperConfig.class)
public abstract class MatchhistoryOverviewMapper {

    @Mapping(target = "playerData", ignore = true)
    public abstract MatchhistoryEntryOverview toOverview(MatchhistoryEntry matchhistoryEntry, @Context String puuid);

    @AfterMapping
    protected void updateSummonerSpecificValues(@MappingTarget final MatchhistoryEntryOverview target,
                                                final MatchhistoryEntry source,
                                                @Context String puuid) {
        final Participant summonerData = source.getParticipants().stream()
                .filter(participant -> participant.getPuuid().equals(puuid))
                .findFirst()
                .orElseThrow(ResourceNotFoundException::new);

        target.setPlayerData(summonerData);
    }
}
