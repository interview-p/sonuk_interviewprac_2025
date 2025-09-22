package com.microservice_3.microservice_3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice_3.microservice_3.circuitBreaker.CircuitBreakerService;


@RestController
@RequestMapping("/microservice3")
public class Controller {

	@Autowired
	private CircuitBreakerService circuitBreakerService;
	
	 @GetMapping("/test")
	 public String test() {
	      return circuitBreakerService.callRemoteService();
	 }
	 
	 @GetMapping("/check-retry")
	 public String check_test() {
	      return circuitBreakerService.callRetryRemoteService();
	 }
	 
	 @GetMapping("/proxy-check")
	 public String proxyCheck() {
	     System.out.println("Controller sees bean class = " + circuitBreakerService.getClass().getName());
	     return "Check logs for proxy class name";
	 }
	
}
