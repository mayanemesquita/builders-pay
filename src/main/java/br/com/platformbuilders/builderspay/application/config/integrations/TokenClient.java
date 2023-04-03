package br.com.platformbuilders.builderspay.application.config.integrations;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "token", url = "https://vagas.builders/api/builders/auth")
public interface TokenClient {

    @PostMapping(value = "/tokens", consumes = MediaType.APPLICATION_JSON_VALUE)
    TokenAPI getToken(@RequestBody TokenAPI tokenAPI);
}
