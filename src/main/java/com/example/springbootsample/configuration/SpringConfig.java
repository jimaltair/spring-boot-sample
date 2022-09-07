package com.example.springbootsample.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;
import springfox.documentation.spring.web.readers.operation.HandlerMethodResolver;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Configuration
public class SpringConfig implements WebMvcConfigurer {
    // For correct working Springfox 3.0.0 with Spring Boot 2.6.x and higher.
    // Maybe it will be fixed in next versions of Springfox
    @Bean
    public WebMvcRequestHandlerProvider webMvcRequestHandlerProvider(
            Optional<ServletContext> servletContext,
            HandlerMethodResolver methodResolver,
            List<RequestMappingInfoHandlerMapping> handlerMappings) {
        handlerMappings = handlerMappings
                .stream()
                .filter(mapping -> mapping.getPatternParser() == null)
                .collect(toList());
        return new WebMvcRequestHandlerProvider(servletContext, methodResolver, handlerMappings);
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }
}
