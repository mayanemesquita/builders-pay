package br.com.platformbuilders.builderspay.core.domain;

import jakarta.ws.rs.BadRequestException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class BoletoTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void validarBoleto() {
        BadRequestException badRequestException = Assertions.assertThrows(BadRequestException.class, () -> Boleto
                .validarBoleto(LocalDate.of(2023, Month.APRIL, 1), LocalDate.of(2023, Month.JANUARY, 20), "NPC"));
        assertTrue(badRequestException.getMessage().contains("Data de pagamento ou tipo de boleto inválido"));
    }

    @Test
    void calculcarTotal() {
        Boleto retorno = Boleto.calculcarTotal("codigoBarras", LocalDate.of(2023, Month.APRIL, 3), LocalDate.of(2023, Month.MARCH, 24), new BigDecimal("500.00"));
        Assertions.assertEquals(new BigDecimal("10.00"), retorno.valorMulta());
        Assertions.assertEquals(new BigDecimal("1.66"), retorno.valorJuros());
        Assertions.assertEquals(new BigDecimal("511.66"), retorno.valorAtual());
        Assertions.assertNotNull(retorno.dataVencimento());
        Assertions.assertNotNull(retorno.dataPagamento());
    }
}