package br.com.platformbuilders.builderspay.application.adapters.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;


@JsonIgnoreProperties(ignoreUnknown = true)
public record BoletoRequest (

    @JsonProperty("bar_code")
    String codigoBarras,
    @JsonProperty("payment_date")
    LocalDate dataPagamento)
    {
}
