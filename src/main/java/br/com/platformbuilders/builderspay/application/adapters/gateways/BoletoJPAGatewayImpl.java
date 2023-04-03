package br.com.platformbuilders.builderspay.application.adapters.gateways;

import br.com.platformbuilders.builderspay.application.adapters.presenters.BoletoMapper;
import br.com.platformbuilders.builderspay.application.config.database.BoletoEntity;
import br.com.platformbuilders.builderspay.application.config.database.BoletoRepository;
import br.com.platformbuilders.builderspay.core.domain.Boleto;
import br.com.platformbuilders.builderspay.core.ports.BoletoJPAGateway;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

@Repository
public class BoletoJPAGatewayImpl implements BoletoJPAGateway {
    BoletoRepository boletoRepository;

    public BoletoJPAGatewayImpl(BoletoRepository boletoRepository) {
        this.boletoRepository = boletoRepository;
    }

    @Override
    public void salvar(Boleto boleto) {
        BoletoEntity boletoEntity = boletoRepository.save(Mappers.getMapper(BoletoMapper.class).fromDomain(boleto));
    }
}
