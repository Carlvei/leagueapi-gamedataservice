package at.adesso.leagueapi.gamedataservice.infrastructure.config.errorhandling.exception;

import at.adesso.leagueapi.gamedataservice.infrastructure.config.errorhandling.error.CommonError;

public class ResourceNotFoundException extends ApiException {

    public ResourceNotFoundException() {
        super(CommonError.RESOURCE_NOT_FOUND);
    }
}
