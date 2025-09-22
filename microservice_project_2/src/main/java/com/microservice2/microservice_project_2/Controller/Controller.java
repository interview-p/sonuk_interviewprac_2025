package com.microservice2.microservice_project_2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice2.microservice_project_2.DTO.CircuitBreakerEventDTO;
import com.microservice2.microservice_project_2.circuitBreaker.ProgrammaticCircuitBreakerService;

import io.github.resilience4j.circuitbreaker.event.CircuitBreakerEvent;

@RestController
@RequestMapping("/microservice2")
public class Controller {

	
	private final ProgrammaticCircuitBreakerService circuitBreakerServices;
	private final List<CircuitBreakerEvent> events;
	
	public Controller(ProgrammaticCircuitBreakerService service,List<CircuitBreakerEvent> events) {
        this.circuitBreakerServices = service;
        this.events = events;
    }
	
	@GetMapping("/hello")
	 public String addPassword() {
	        return "hello namaskar ap kaise ho this is microservice-2";
	 }
	
	 @GetMapping("/test")
	 public String test() {
	      return circuitBreakerServices.callRemoteService();
	 }
	 
	 
	 @GetMapping("/proxy-check")
	 public String proxyCheck() {
	     System.out.println("Controller sees bean class = " + circuitBreakerServices.getClass().getName());
	     return "Check logs for proxy class name";
	 }
	 
	 
	 @GetMapping("/programmatic-events")
	 public List<CircuitBreakerEventDTO> getEvents() {
		 return events.stream()
                 .map(CircuitBreakerEventDTO::new)
                 .toList();
	 }
	 
	 
}
