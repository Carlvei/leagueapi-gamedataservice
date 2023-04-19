package at.adesso.leagueapi.gamedataservice.application.datadragon.assets;

import at.adesso.leagueapi.gamedataservice.application.datadragon.AbstractDataDragonApplicationService;
import at.adesso.leagueapi.gamedataservice.infrastructure.config.model.DataDragonProperties;
import org.springframework.stereotype.Service;

@Service
public class AssetsApplicationService extends AbstractDataDragonApplicationService {

    private static final String TYPE_NAME = "assets";
    private static final String PROFILE_ICONS_SUBJECT_NAME = "profile-icons";
    private static final String CHAMPION_ICONS_SUBJECT_NAME = "champions";
    private static final String ITEMS_ICONS_SUBJECT_NAME = "items";

    protected AssetsApplicationService(final DataDragonProperties properties) {
        super(properties);
    }

    public String getProfileIconUrl(final Integer profileIconId) {
        return buildProfileIconUrl(profileIconId);
    }

    public String getChampionIconUrl(final String championName) {
        return buildChampionIconUrl(championName);
    }

    public String getItemIconUrl(final Integer itemId) {
        return buildItemIconUrl(itemId);
    }


    private String buildProfileIconUrl(final Integer profileIconId) {
        return getUrl(TYPE_NAME, PROFILE_ICONS_SUBJECT_NAME) + profileIconId + ".png";
    }

    private String buildChampionIconUrl(final String championName) {
        return getUrl(TYPE_NAME, CHAMPION_ICONS_SUBJECT_NAME) + championName + ".png";
    }

    private String buildItemIconUrl(final Integer itemId) {
        return getUrl(TYPE_NAME, ITEMS_ICONS_SUBJECT_NAME) + itemId + ".png";
    }
}
