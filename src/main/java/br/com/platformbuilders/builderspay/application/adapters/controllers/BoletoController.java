package br.com.platformbuilders.builderspay.application.adapters.controllers;

import br.com.platformbuilders.builderspay.application.adapters.presenters.BoletoMapper;
import br.com.platformbuilders.builderspay.core.domain.Boleto;
import br.com.platformbuilders.builderspay.core.ports.BoletoInputPort;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BoletoController {
    BoletoInputPort boletoInputPort;

    public BoletoController(BoletoInputPort boletoInputPort) {
        this.boletoInputPort = boletoInputPort;
    }

    @PostMapping("/boletos")
    public ResponseEntity<BoletoResponse> boleto(@Valid @RequestBody BoletoRequest boletoRequest) {
        Boleto boleto = boletoInputPort.buscarBoleto(boletoRequest.codigoBarras(), boletoRequest.dataPagamento());
        return new ResponseEntity<>(Mappers.getMapper(BoletoMapper.class).toDomain(boleto), HttpStatus.OK);
    }
}
