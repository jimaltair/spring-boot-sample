package com.example.springbootsample;

import com.example.springbootsample.configuration.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{
                SpringBootSampleApplication.class,
                SwaggerConfig.class
        }, args);
    }

}
