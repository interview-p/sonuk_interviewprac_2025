package com.microservice_loadbalancer.microservice_loadbalancer.forwarder;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/lb/micro8")
public class microservic8_Forwarder {

	private final RestTemplate rest;

    public microservic8_Forwarder(RestTemplate rest) {
        this.rest = rest;
    }

    @GetMapping("/check")
    public String check() {
    	   return "Hai this is loadbalancer";
    }
    
    @RequestMapping("/**")
    public String forward(HttpServletRequest request, HttpEntity<String> entity) {
        String path = request.getRequestURI().replace("/lb/micro8", "");
        String url = "http://MICROSERVICE8" + "/micro8"+path;
        return rest.getForObject(url, String.class);
        //return rest.exchange(url, HttpMethod.valueOf(request.getMethod()), entity, String.class);
    }
    
}
