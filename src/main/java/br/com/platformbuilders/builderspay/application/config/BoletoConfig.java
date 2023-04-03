package br.com.platformbuilders.builderspay.application.config;

import br.com.platformbuilders.builderspay.core.ports.BoletoJPAGateway;
import br.com.platformbuilders.builderspay.core.ports.DetalhesBoletoGateway;
import br.com.platformbuilders.builderspay.core.ports.BoletoInputPort;
import br.com.platformbuilders.builderspay.core.usecase.GetBoletoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoletoConfig {

    @Bean
    BoletoInputPort boletoInputPort (final DetalhesBoletoGateway detalhesBoletoGateway, final BoletoJPAGateway boletoJPAGateway ){
        return new GetBoletoUseCase(detalhesBoletoGateway, boletoJPAGateway);
    }
}
