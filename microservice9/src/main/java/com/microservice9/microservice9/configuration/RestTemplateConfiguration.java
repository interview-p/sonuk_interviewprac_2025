package com.microservice9.microservice9.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

	
    @Bean
    @LoadBalanced   // Important: enables service discovery
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    
}
