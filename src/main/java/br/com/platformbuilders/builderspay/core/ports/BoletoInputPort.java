package br.com.platformbuilders.builderspay.core.ports;

import br.com.platformbuilders.builderspay.core.domain.Boleto;

import java.time.LocalDate;

public interface BoletoInputPort {
    Boleto buscarBoleto(String codigoBarras, LocalDate dataPagamento);
}
