package com.microservice2.microservice_project_2.DTO;

import io.github.resilience4j.circuitbreaker.event.CircuitBreakerEvent;
import io.github.resilience4j.circuitbreaker.event.CircuitBreakerOnErrorEvent;

public class CircuitBreakerEventDTO {

	
	private String type;
    private String circuitBreakerName;
    private String creationTime;
    private String errorMessage;

    public CircuitBreakerEventDTO(CircuitBreakerEvent event) {
        this.type = event.getEventType().name();
        this.circuitBreakerName = event.getCircuitBreakerName();
        this.creationTime = event.getCreationTime().toString();
        
        if (event instanceof CircuitBreakerOnErrorEvent errorEvent) {
            this.errorMessage = errorEvent.getThrowable() != null 
                    ? errorEvent.getThrowable().getMessage() 
                    : null;
        } else {
            this.errorMessage = null;
        }
    }

    // getters
    public String getType() { return type; }
    public String getCircuitBreakerName() { return circuitBreakerName; }
    public String getCreationTime() { return creationTime; }
    public String getErrorMessage() { return errorMessage; }
    
    
}
