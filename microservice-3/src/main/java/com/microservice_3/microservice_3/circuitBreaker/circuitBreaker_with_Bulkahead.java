package com.microservice_3.microservice_3.circuitBreaker;

import org.springframework.stereotype.Service;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class circuitBreaker_with_Bulkahead {

	 // Combined CircuitBreaker + Bulkhead method
    @CircuitBreaker(name = "remoteService", fallbackMethod = "circuitFallback")
    @Bulkhead(name = "serviceABulkhead", type = Bulkhead.Type.SEMAPHORE, fallbackMethod = "bulkheadFallback")
    public String processRequest(String requestName) throws InterruptedException {
        System.out.println("Processing request: " + requestName + " in thread: " + Thread.currentThread().getName());
        // Simulate long running process
        Thread.sleep(5000);
        return "✅ Request " + requestName + " completed successfully!";
    }

    // Bulkhead fallback: throw exception to be counted by CircuitBreaker
    public String bulkheadFallback(String requestName, Throwable t) {
        System.out.println("Bulkhead fallback triggered for " + requestName + " - " + t.getMessage());
        throw new RuntimeException("Bulkhead limit exceeded for " + requestName, t);
    }

    // CircuitBreaker fallback
    public String circuitFallback(String requestName, Throwable t) {
        System.out.println("CircuitBreaker fallback triggered for " + requestName + " - " + t.getMessage());
        return "❌ CircuitBreaker fallback: " + t.getMessage();
    }
}
