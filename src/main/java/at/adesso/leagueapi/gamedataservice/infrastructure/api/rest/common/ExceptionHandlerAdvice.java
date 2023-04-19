package at.adesso.leagueapi.gamedataservice.infrastructure.api.rest.common;

import at.adesso.leagueapi.gamedataservice.infrastructure.config.errorhandling.AbstractExceptionHandlerAdvice;
import at.adesso.leagueapi.gamedataservice.infrastructure.config.errorhandling.ErrorResponseFactory;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerAdvice extends AbstractExceptionHandlerAdvice {

    protected ExceptionHandlerAdvice(final ErrorResponseFactory responseFactory) {
        super(responseFactory);
    }

    @Override
    protected Logger getLogger() {
        return log;
    }
}
