package com.microservice15.microservice15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/microservice15")
public class controller {

	@Autowired
	private RestTemplate restTemplate;
	 
    @GetMapping("/hello")
    public String hello() {
        return "Hello from service-a";
    }
    
   	

    @GetMapping("/call-b")
    public String callServiceB() {
        String response = restTemplate.getForObject("http://service-b:8080/micro16/microservice16/hello", String.class);
        return "Service-A received: " + response;
    }
}
