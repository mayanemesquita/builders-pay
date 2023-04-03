package br.com.platformbuilders.builderspay.application.adapters.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BoletoResponse {

    @JsonProperty("original_amount")
    BigDecimal valorOriginal;
    @JsonProperty("amount")
    BigDecimal valorAtual;
    @JsonProperty("payment_date")
    LocalDate dataPagamento;
    @JsonProperty("due_date")
    LocalDate dataVencimento;
    @JsonProperty("interest_amount_calculated")
    BigDecimal valorJuros;
    @JsonProperty("fine_amount_calculated")
    BigDecimal valorMulta;
}
