package com.example.springbootsample.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.springbootsample.controller"})
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("springbootsample-public")
                .pathsToMatch("/demo/**")
                .build();
    }

    @Bean
    public OpenAPI springBootExampleOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SpringBoot-Sample API")
                        .description("Spring boot sample application")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Developer")
                                .email("developer@mycompany.com")
                                .url("mycompany.com")));
    }
}
