package at.adesso.leagueapi.gamedataservice.application.matchhistory.mapper;

import at.adesso.leagueapi.commons.errorhandling.exceptions.ResourceNotFoundException;
import at.adesso.leagueapi.commons.mapper.DefaultMapperConfig;
import at.adesso.leagueapi.gamedataservice.application.summoners.matchhistory.MatchhistoryEntry;
import at.adesso.leagueapi.gamedataservice.application.summoners.matchhistory.MatchhistoryEntryOverview;
import at.adesso.leagueapi.gamedataservice.application.summoners.matchhistory.Participant;
import org.mapstruct.*;

@Mapper(config = DefaultMapperConfig.class)
public abstract class MatchhistoryOverviewMapper {

    @Mapping(target = "playerData", ignore = true)
    public abstract MatchhistoryEntryOverview toOverview(MatchhistoryEntry matchhistoryEntry, @Context String puuid);

    @AfterMapping
    protected void updateSummonerSpecificValues(@MappingTarget final MatchhistoryEntryOverview target,
                                                final MatchhistoryEntry source,
                                                @Context final String puuid) {
        final Participant summonerData = source.getParticipants().stream()
                .filter(participant -> participant.getPuuid().equals(puuid))
                .findFirst()
                .orElseThrow(ResourceNotFoundException::new);

        target.setPlayerData(summonerData);
    }
}
