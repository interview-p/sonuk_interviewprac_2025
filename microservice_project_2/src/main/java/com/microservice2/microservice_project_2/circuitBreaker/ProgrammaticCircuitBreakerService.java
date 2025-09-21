package com.microservice2.microservice_project_2.circuitBreaker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.decorators.Decorators;
import io.github.resilience4j.circuitbreaker.event.CircuitBreakerEvent;

@Service
public class ProgrammaticCircuitBreakerService {

	/*
	 private final RestTemplate restTemplate;
	 private final CircuitBreaker circuitBreaker;
	 
	    public ProgrammaticCircuitBreakerService(RestTemplate restTemplate, CircuitBreaker circuitBreaker) {
	        this.restTemplate = restTemplate;
	        this.circuitBreaker = circuitBreaker;
	    }

	    public String callRemoteService() {
	        String url = "http://localhost:8080/circuit/api/data";

	        Supplier<String> decoratedSupplier = Decorators
	                .ofSupplier(() -> restTemplate.getForObject(url, String.class))
	                .withCircuitBreaker(circuitBreaker)
	                .decorate();

	        try {
	            return decoratedSupplier.get();
	        } catch (Exception ex) {
	            return fallback(ex);
	        }
	    }

	    public String fallback(Throwable t) {
	        return "Fallback executed: " + t.getMessage();
	    }
    */
}
