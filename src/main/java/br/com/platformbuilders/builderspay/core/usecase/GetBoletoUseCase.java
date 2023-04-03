package br.com.platformbuilders.builderspay.core.usecase;

import br.com.platformbuilders.builderspay.application.config.integrations.BoletoAPI;
import br.com.platformbuilders.builderspay.core.domain.Boleto;
import br.com.platformbuilders.builderspay.core.ports.BoletoInputPort;
import br.com.platformbuilders.builderspay.core.ports.BoletoJPAGateway;
import br.com.platformbuilders.builderspay.core.ports.DetalhesBoletoGateway;

import java.time.LocalDate;

public class GetBoletoUseCase implements BoletoInputPort {

    private final DetalhesBoletoGateway detalhesBoletoGateway;

    private final BoletoJPAGateway boletoJPAGateway;


    public GetBoletoUseCase(DetalhesBoletoGateway detalhesBoletoGateway,
                            BoletoJPAGateway boletoJPAGateway) {
        this.detalhesBoletoGateway = detalhesBoletoGateway;
        this.boletoJPAGateway = boletoJPAGateway;
    }

    @Override
    public Boleto buscarBoleto(String codigoBarras, LocalDate dataPagamento) {

        BoletoAPI detalhes = detalhesBoletoGateway.buscarDetalhesBoleto(codigoBarras);
        Boleto.validarBoleto(dataPagamento, detalhes.getDataVencimento(), detalhes.getTipoBoleto());
        Boleto boletoCalculado = Boleto.calculcarTotal(codigoBarras, dataPagamento, detalhes.getDataVencimento(), detalhes.getValorOriginal());
        boletoJPAGateway.salvar(boletoCalculado);

        return boletoCalculado;

    }
}
