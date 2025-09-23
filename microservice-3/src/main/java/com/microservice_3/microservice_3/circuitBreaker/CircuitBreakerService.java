package com.microservice_3.microservice_3.circuitBreaker;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.annotation.PostConstruct;

@Service
public class CircuitBreakerService {

	 private final RestTemplate restTemplate;

	    public CircuitBreakerService(RestTemplate restTemplate) {
	        this.restTemplate = restTemplate;
	    }

	    @PostConstruct
	    public void checkProxy() {
	        System.out.println("CircuitBreakerService bean class = " + this.getClass().getName());
	    }
	    
	    
	    @CircuitBreaker(name = "remoteService", fallbackMethod = "fallback")
	    //@Retry(name = "remoteServiceRetry", fallbackMethod = "retryfallback")
	    public String callRemoteService() {
	        String url = "http://localhost:8080/circuit/api/data"; // Third-party service URL
	        return restTemplate.getForObject(url, String.class);
	    }
	    
	    @Retry(name = "remoteServiceRetry", fallbackMethod = "retryfallback")
	    public String callRetryRemoteService() {
	        System.out.println("Attempt at " + System.currentTimeMillis());
	        throw new RuntimeException("Simulated failure");
	    }
	    
	    @Bulkhead(name = "serviceABulkhead", type = Bulkhead.Type.SEMAPHORE , fallbackMethod = "semaphorefallback")
	    public String heavyProcess() throws InterruptedException {
	        System.out.println("Executing heavy process in thread: " + Thread.currentThread().getName());
	        Thread.sleep(10000); // simulate long processing (5 sec)
	        return "✅ Process completed successfully!";
	    }

	    // Fallback method in case the remote service fails
	    public String fallback(Throwable t) {
	        return "circuitrBreaker Fallback response: Remote service is down! Error: " + t.getMessage();
	    }
	    
	    public String retryfallback(Throwable t) {
	        return "retry Fallback response: Remote service is down! Error: " + t.getMessage();
	    }
	    
	    public String semaphorefallback(Throwable t) {
	        return "❌ Too many concurrent requests! Please try again later this is semaphore bulkahead";
	    }
	    
}
