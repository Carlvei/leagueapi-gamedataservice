package at.adesso.leagueapi.gamedataservice.application.datadragon;

import at.adesso.leagueapi.gamedataservice.infrastructure.config.model.DataDragonProperties;

public abstract class AbstractDataDragonApplicationService {

    protected final DataDragonProperties properties;

    protected AbstractDataDragonApplicationService(DataDragonProperties properties) {
        this.properties = properties;
    }

    protected String getUrl(final String type, final String subject) {
        return properties.getTypeProperties(type)
                .getSubjectProperties(subject)
                .getUrl();
    }
}
