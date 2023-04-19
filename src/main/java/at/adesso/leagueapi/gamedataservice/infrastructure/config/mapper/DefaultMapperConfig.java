package at.adesso.leagueapi.gamedataservice.infrastructure.config.mapper;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.MapperConfig;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValueMapMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface DefaultMapperConfig {
}
