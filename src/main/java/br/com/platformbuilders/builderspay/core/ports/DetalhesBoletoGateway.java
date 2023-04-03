package br.com.platformbuilders.builderspay.core.ports;

import br.com.platformbuilders.builderspay.application.config.integrations.BoletoAPI;

public interface DetalhesBoletoGateway {
    BoletoAPI buscarDetalhesBoleto(String code);
}
