package br.com.platformbuilders.builderspay;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BuildersPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuildersPayApplication.class, args);
    }

}
