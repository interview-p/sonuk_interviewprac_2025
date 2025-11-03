package com.microservice15.microservice15.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.Tracer;



@RestController
@RequestMapping("/microservice15")
public class controller {

	

	    private final RestTemplate rest;
	    private final Tracer tracer;

	    public controller(RestTemplate rest, Tracer tracer) {
	        this.rest = rest;
	        this.tracer = tracer;
	    }
	    
	@GetMapping("/call-b")
    public ResponseEntity<String> callB() {
        // Manual span around business call
        Span span = tracer.spanBuilder("service-a.call-b-business-span").startSpan();
        try {
            String url = "http://service-b:8080/hello";
            String resp = rest.getForObject(url, String.class);
            return ResponseEntity.ok("service-a -> " + resp);
        } finally {
            span.end();
        }
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from service-a";
    }
}
