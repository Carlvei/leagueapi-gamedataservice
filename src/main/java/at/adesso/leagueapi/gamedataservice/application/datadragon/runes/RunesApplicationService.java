package at.adesso.leagueapi.gamedataservice.application.datadragon.runes;

import at.adesso.leagueapi.commons.errorhandling.exceptions.ResourceNotFoundException;
import at.adesso.leagueapi.gamedataservice.application.datadragon.AbstractDataDragonApplicationService;
import at.adesso.leagueapi.gamedataservice.domain.runes.Rune;
import at.adesso.leagueapi.gamedataservice.domain.runes.RuneTree;
import at.adesso.leagueapi.gamedataservice.infrastructure.adapter.riot.runes.RiotRunesAdapter;
import at.adesso.leagueapi.gamedataservice.infrastructure.config.model.DataDragonProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RunesApplicationService extends AbstractDataDragonApplicationService {

    private static final String TYPE_NAME = "assets";
    private static final String RUNES_SUBJECT_NAME = "runes";
    private final RiotRunesAdapter riotRunesAdapter;

    protected RunesApplicationService(final DataDragonProperties properties,
                                      final RiotRunesAdapter riotRunesAdapter) {
        super(properties);
        this.riotRunesAdapter = riotRunesAdapter;
    }

    public String getRuneIconUrl(final int runeIconId) {
        return buildUrl(getUrlExtension(runeIconId));
    }

    private String buildUrl(final String urlExtension) {
        return getUrl(TYPE_NAME, RUNES_SUBJECT_NAME) + urlExtension;
    }

    private List<RuneTree> getRunes() {
        return riotRunesAdapter.queryRunes();
    }

    private List<Rune> getListOfRunes() {
        final List<RuneTree> runeTrees = getRunes();
        return runeTrees.stream()
                .flatMap(runeTree -> runeTree.getSlots().stream()
                        .flatMap(runeSlot -> runeSlot.getRunes().stream()))
                .toList();
    }

    private String getUrlExtension(final int runeIconId) {
        return getListOfRunes().stream()
                .filter(rune -> rune.getId() == runeIconId)
                .findFirst()
                .orElseThrow(ResourceNotFoundException::new)
                .getIcon();
    }
}
