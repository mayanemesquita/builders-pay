package br.com.platformbuilders.builderspay.application.config.integrations;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "boleto", url = "https://vagas.builders/api/builders/bill-payments")
public interface BoletoClient {

    @PostMapping(value = "/codes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    BoletoAPI buscarDetalhesBoleto(@RequestBody BoletoAPI boletoAPI, @RequestHeader("Authorization") String token);
    }

