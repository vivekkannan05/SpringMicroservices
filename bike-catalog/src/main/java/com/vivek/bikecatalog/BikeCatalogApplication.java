package com.vivek.bikecatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BikeCatalogApplication {

    @Bean
    public RestTemplate createRestTemplateBean(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(BikeCatalogApplication.class, args);
    }

}
