package com.example.simulator.configurations.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerBearerConfig {
    private static final String SCHEME_NAME = "bearerAuth";
    private static final String SCHEME = "bearer";

    @Bean
    OpenAPI customOpenApi(
            @Value("${simulator.swagger.server.url}") String url,
            @Value("${simulator.swagger.server.local-url}") String localUrl,
            @Value("${simulator.swagger.info.title}") String title,
            @Value("${simulator.swagger.info.description}") String description,
            @Value("${simulator.swagger.info.version}") String version
    ) {
        return new OpenAPI()
                .addServersItem(new Server().url(url))
                .addServersItem(new Server().url(localUrl))
                .info(new Info()
                        .title(title)
                        .description(description)
                        .version(version))
                .components(new Components()
                        .addSecuritySchemes(SCHEME_NAME, createBearerScheme()))
                .addSecurityItem(new SecurityRequirement().addList(SCHEME_NAME));
    }

    private SecurityScheme createBearerScheme() {
        return new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme(SCHEME);
    }
}
