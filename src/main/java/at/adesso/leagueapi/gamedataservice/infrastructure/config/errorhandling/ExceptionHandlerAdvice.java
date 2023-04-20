package at.adesso.leagueapi.gamedataservice.infrastructure.config.errorhandling;

import at.adesso.leagueapi.commons.errorhandling.AbstractExceptionHandlerAdvice;
import at.adesso.leagueapi.commons.errorhandling.ErrorResponseFactory;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;

@Slf4j
public class ExceptionHandlerAdvice extends AbstractExceptionHandlerAdvice {

    protected ExceptionHandlerAdvice(ErrorResponseFactory responseFactory) {
        super(responseFactory);
    }

    @Override
    protected Logger getLogger() {
        return log;
    }
}
