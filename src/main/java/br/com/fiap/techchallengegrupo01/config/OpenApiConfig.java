package br.com.fiap.techchallengegrupo01.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("REST API Monitoramento de energia")
                        .version("v1")
                        .description("API de monitoramento de energia para uso residencial e comercial.")
                        .termsOfService("https://github.com/SavioRony/tech-challenge-grupo-01.git")
                        .license(new License().url("https://github.com/SavioRony/tech-challenge-grupo-01.git")));
    }
}
