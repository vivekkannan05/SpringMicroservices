package com.vivek.bikecatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableEurekaClient. Will let the Eureka server to know that a client is available and will be registered.
 */
@SpringBootApplication
@EnableEurekaClient
public class BikeCatalogApplication {

    /**
     * The restTemplate bean is loadBalanced so that the restTemplate is smart enough to pick the right service from discovery server
     * and also load balance if multiple instance of same API is available.
     * @return restTemplateBean returns a resttemplateBean
     */
    @Bean
    @LoadBalanced
    public RestTemplate createRestTemplateBean(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(BikeCatalogApplication.class, args);
    }

}
