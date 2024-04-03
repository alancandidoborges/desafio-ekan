package com.ekan.config.security.configuration.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customAPI(){
        return new OpenAPI().info(new Info()
                .title("API Desafio Ekan")
                .version("1.0.0")
                .description("API desenvolvida para o desavfio da Ekan")
                .license(new License().name("Licença: Free"))
        );
    }
}
