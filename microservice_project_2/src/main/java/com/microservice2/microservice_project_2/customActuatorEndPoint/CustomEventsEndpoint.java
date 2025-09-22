package com.microservice2.microservice_project_2.customActuatorEndPoint;

import java.util.List;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import com.microservice2.microservice_project_2.DTO.CircuitBreakerEventDTO;

import io.github.resilience4j.circuitbreaker.event.CircuitBreakerEvent;

@Component
@Endpoint(id = "events")
public class CustomEventsEndpoint {

	
	 private final List<CircuitBreakerEvent> events;

	    public CustomEventsEndpoint(List<CircuitBreakerEvent> events) {
	        this.events = events;
	    }

	    @ReadOperation
	    public List<CircuitBreakerEventDTO> events() {
	    	return events.stream()
	                 .map(CircuitBreakerEventDTO::new)
	                 .toList();
	    }
	    
	    
}
