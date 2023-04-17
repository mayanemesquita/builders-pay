package br.com.platformbuilders.builderspay.application.adapters.controllers;

import br.com.platformbuilders.builderspay.core.ports.BoletoInputPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BoletoControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    BoletoInputPort boletoInputPort;

    @Test
    void boleto() {
        BoletoRequest boletoRequest = new BoletoRequest("34191790010104351004791020150008291070026000", LocalDate.of(2023, Month.APRIL, 5));
        HttpEntity<BoletoRequest> httpEntity = new HttpEntity<>(boletoRequest);
        ResponseEntity<BoletoResponse> response = this.testRestTemplate
                .exchange("/boletos", HttpMethod.POST, httpEntity, BoletoResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}