package br.com.platformbuilders.builderspay.application.adapters.gateways;

import br.com.platformbuilders.builderspay.application.config.integrations.BoletoAPI;
import br.com.platformbuilders.builderspay.application.config.integrations.BoletoClient;
import br.com.platformbuilders.builderspay.application.config.integrations.TokenAPI;
import br.com.platformbuilders.builderspay.application.config.integrations.TokenClient;
import br.com.platformbuilders.builderspay.core.ports.DetalhesBoletoGateway;
import feign.FeignException;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.NotAuthorizedException;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class DetalhesBoletoGatewayImpl implements DetalhesBoletoGateway {
    TokenClient tokenClient;
    BoletoClient boletoClient;

    public DetalhesBoletoGatewayImpl(TokenClient tokenClient, BoletoClient boletoClient) {
        this.tokenClient = tokenClient;
        this.boletoClient = boletoClient;
    }

    @Override
    public BoletoAPI buscarDetalhesBoleto(String code) {
        String token = getToken();
        BoletoAPI boletoAPI = getBoletoAPI(code);
        BoletoAPI detalhe = null;
        try {
            detalhe = boletoClient.buscarDetalhesBoleto(boletoAPI, token);
        } catch (FeignException.BadRequest badRequest) {
            log.error("Erro ao buscar detalhes do Boleto", badRequest);
            throw new BadRequestException("Erro ao buscar detalhes do Boleto", badRequest);
        }
        return detalhe;
    }

    private String getToken() {
        String token = null;
        try {
            token = tokenClient.getToken(
                    new TokenAPI("bd753592-cf9b-4d1a-96b9-cb8b2c01bd12", "4e8229fe-1131-439c-9846-799895a8be5b")).getToken();
        } catch (FeignException.Unauthorized unauthorized) {
            log.error("Erro na API de Autenticação", unauthorized);
            throw new NotAuthorizedException("Erro na API de Autenticação", unauthorized);
        }
        return token;
    }

    private static BoletoAPI getBoletoAPI(String code) {
        BoletoAPI boletoAPI = new BoletoAPI();
        boletoAPI.setCode(code);
        return boletoAPI;
    }
}



