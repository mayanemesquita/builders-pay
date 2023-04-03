package br.com.platformbuilders.builderspay.core.ports;

import br.com.platformbuilders.builderspay.core.domain.Boleto;

public interface BoletoJPAGateway {
    void salvar(Boleto boleto);
}
