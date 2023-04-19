package at.adesso.leagueapi.gamedataservice.infrastructure.config.model;

import lombok.Data;

import java.util.Map;

@Data
public class DataDragonTypeProperties {
    private Map<String, DataDragonSubjectProperties> subjects;

    public DataDragonSubjectProperties getSubjectProperties(final String subject) {
        return subjects.get(subject);
    }
}
