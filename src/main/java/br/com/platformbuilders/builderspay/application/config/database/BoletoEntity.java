package br.com.platformbuilders.builderspay.application.config.database;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@Entity
@Table(name = "boleto")
public class BoletoEntity {
    @Id
    String id;
    @Column(name = "codigo_barras")
    String codigoBarras;
    @Column(name = "data_pagamento")
    LocalDate dataPagamento;
    @Column(name = "data_vencimento")
    LocalDate dataVencimento;
    @Column(name = "valor_original")
    BigDecimal valorOriginal;
    @Column(name = "valor_atual")
    BigDecimal valorAtual;
    @Column(name = "juros")
    BigDecimal valorJuros;
    @Column(name = "multa")
    BigDecimal valorMulta;
}
