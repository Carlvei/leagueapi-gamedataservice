package at.adesso.leagueapi.gamedataservice.application.datadragon.runes;

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
        final String urlExtension = getUrlExtension(runeIconId);
        return urlExtension == null ? ASSET_NOT_FOUND_KEY : buildUrl(urlExtension);
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
        final Rune rune = getListOfRunes().stream()
                .filter(runeElement -> runeElement.getId() == runeIconId)
                .findFirst()
                .orElse(null);

        return rune == null ? null : rune.getIcon();
    }
}
