package br.com.platformbuilders.builderspay.core.ports;

import br.com.platformbuilders.builderspay.core.domain.Boleto;
import jakarta.transaction.Transactional;

public interface BoletoJPAGateway {
    @Transactional
    void salvar(Boleto boleto);
}
