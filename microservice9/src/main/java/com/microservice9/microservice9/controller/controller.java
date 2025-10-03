package com.microservice9.microservice9.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/microservice9")
public class controller {

	@Autowired
    private RestTemplate restTemplate;
	
	    @GetMapping("/check")
	    public String getOrder() {
	        return "Hai this is microservice9";
	    }
	    
	    

	    @GetMapping("/sdcheck")
	    public String sdcheck() {
	        // microservice6-service is the name in Eureka
	        String url = "http://MICROSERVICE6/micro6/microservice6/check";
	        return restTemplate.getForObject(url, String.class);
	    }
}
