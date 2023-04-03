package br.com.platformbuilders.builderspay.application.config.integrations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BoletoAPI {
    @JsonProperty("code")
    private String code;
    @JsonProperty("due_date")
    private LocalDate dataVencimento;
    @JsonProperty("amount")
    private BigDecimal valorOriginal;
    @JsonProperty("recipient_name")
    private String recipientName;
    @JsonProperty("recipient_document")
    private String recipientDocument;
    @JsonProperty("type")
    private String tipoBoleto;
}
