package br.com.platformbuilders.builderspay.application.adapters.presenters;

import br.com.platformbuilders.builderspay.application.adapters.controllers.BoletoResponse;
import br.com.platformbuilders.builderspay.application.config.database.BoletoEntity;
import br.com.platformbuilders.builderspay.core.domain.Boleto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;


@Mapper( imports = UUID.class )
public interface BoletoMapper {
    BoletoResponse toDomain(Boleto boleto);
    @Mapping(target = "id", expression = "java(UUID.randomUUID().toString())")
    BoletoEntity fromDomain( Boleto boleto);
}
