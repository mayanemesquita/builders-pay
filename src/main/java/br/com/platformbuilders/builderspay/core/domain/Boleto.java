package br.com.platformbuilders.builderspay.core.domain;

import jakarta.ws.rs.BadRequestException;
import lombok.extern.log4j.Log4j2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Log4j2
public record Boleto(
        String codigoBarras,
        LocalDate dataPagamento,
        LocalDate dataVencimento,
        BigDecimal valorOriginal,
        BigDecimal valorAtual,
        BigDecimal valorJuros,
        BigDecimal valorMulta,
        String tipoBoleto
) {

    public static void validarBoleto(LocalDate dataPagamento, LocalDate dataVencimento, String tipoBoleto) {
        if (dataVencimento.isAfter(dataPagamento) || !"NPC".equals(tipoBoleto)) {
            log.error("Não foi possível o realizar cálculo. Boleto não vencido ou tipo de boleto inválido");
            throw new BadRequestException("Boleto em dias ou tipo de boleto inválido");
        }
    }

    public static Boleto calculcarTotal(String codigoBarras, LocalDate dataPagamento, LocalDate dataVencimento, BigDecimal valorOriginal) {
        final BigDecimal percentualMulta = new BigDecimal("0.02");
        final BigDecimal percentualJuros = new BigDecimal("0.01");
        long diasAtaso = ChronoUnit.DAYS.between(dataVencimento, dataPagamento);

        BigDecimal multa = valorOriginal.multiply(percentualMulta).setScale(2, RoundingMode.FLOOR);

        BigDecimal juros = (valorOriginal.multiply(percentualJuros)
                .divide(BigDecimal.valueOf(30), 5, RoundingMode.FLOOR))
                .multiply(BigDecimal.valueOf(diasAtaso)).setScale(2, RoundingMode.FLOOR);

        BigDecimal total = valorOriginal.add(juros).add(multa).setScale(2, RoundingMode.FLOOR);

        return new Boleto(
                codigoBarras,
                dataPagamento,
                dataVencimento,
                valorOriginal,
                total,
                juros,
                multa,
                null);
    }
}
