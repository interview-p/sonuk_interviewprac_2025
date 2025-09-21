package com.microservice2.microservice_project_2.configuration;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.event.CircuitBreakerEvent;

@Configuration
public class CircuitBreakerConfigClass {

	/*
	 private final List<CircuitBreakerEvent> events = new ArrayList<>();
	
	  @Bean
	  public List<CircuitBreakerEvent> circuitBreakerEvents() {
	        return events;  // expose as a bean
	  }
	 
	  @Bean
	  public CircuitBreakerRegistry circuitBreakerRegistry() {
	        return CircuitBreakerRegistry.ofDefaults();
	    }

	    @Bean
	    public CircuitBreaker remoteServiceCircuitBreaker(CircuitBreakerRegistry registry) {
	        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
	                .failureRateThreshold(50)
	                .waitDurationInOpenState(Duration.ofSeconds(5))
	                .slidingWindowSize(2)
	                .minimumNumberOfCalls(2)
	                .build();

	        CircuitBreaker circuitBreaker = registry.circuitBreaker("remoteService", config);

	        // Optional: subscribe to events for logging
	        circuitBreaker.getEventPublisher().onEvent(event ->
	                System.out.println("CircuitBreaker Event: " + event));

	        // Subscribe to events
	        circuitBreaker.getEventPublisher().onEvent(events::add);
	        return circuitBreaker;
	    }
	    
	   */ 
}
