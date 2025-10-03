package com.microservice_loadbalancer.microservice_loadbalancer.forwarder;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/lb/micro7")
public class microservic7_Forwarder {

	private final RestTemplate rest;

    public microservic7_Forwarder(RestTemplate rest) {
        this.rest = rest;
    }

    @RequestMapping("/**")
    public ResponseEntity<String> forward(HttpServletRequest request, HttpEntity<String> entity) {
        String path = request.getRequestURI().replace("/lb/micro7", "");
        String url = "http://microservice7-container" + path;
        return rest.exchange(url, HttpMethod.valueOf(request.getMethod()), entity, String.class);
    }
}
