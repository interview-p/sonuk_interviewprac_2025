package com.microservice_3.microservice_3.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice_3.microservice_3.circuitBreaker.CircuitBreakerService;
import com.microservice_3.microservice_3.circuitBreaker.circuitBreaker_with_Bulkahead;


@RestController
@RequestMapping("/microservice3")
public class Controller {

	@Autowired
	private CircuitBreakerService circuitBreakerService;
	
	@Autowired
	private circuitBreaker_with_Bulkahead bulkahead;
	
	 @GetMapping("/test")
	 public String test() {
	      return circuitBreakerService.callRemoteService();
	 }
	 
	 @GetMapping("/check-retry")
	 public String check_test() {
	      return circuitBreakerService.callRetryRemoteService();
	 }

	 
	 //-----------------------------Bulkhahead----------------------------
	 @GetMapping("/check-bulkahead1")
	 public String bulkahead1() throws InterruptedException {
	      return circuitBreakerService.heavyProcess();
	 }
	 
	 @GetMapping("/check-bulkahead")
	 public String bulkahead() throws InterruptedException {
		 // simulate concurrent calls
	        Runnable task = () -> {
	            try {
	                System.out.println(circuitBreakerService.heavyProcess());
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        };

	        new Thread(task).start();
	        new Thread(task).start();
	        new Thread(task).start(); // 3rd thread should be rejected if maxConcurrentCalls=2

	        return "Triggered 3 concurrent calls";
	    }
	 
	  @GetMapping("/test-bulk-concurrent")
	    public String testConcurrent() {
	        ExecutorService executor = Executors.newFixedThreadPool(5);

	        // Simulate 5 concurrent requests
	        for (int i = 1; i <= 5; i++) {
	            final int idx = i;
	            executor.submit(() -> {
	                try {
	                    System.out.println(bulkahead.processRequest("Req-" + idx));
	                } catch (Exception e) {
	                    System.out.println("Exception: " + e.getMessage());
	                }
	            });
	        }

	        executor.shutdown();
	        return "Triggered 5 concurrent requests";
	    }
	  
	//------------------------------------------------------------------------
	 
	 
	 @GetMapping("/proxy-check")
	 public String proxyCheck() {
	     System.out.println("Controller sees bean class = " + circuitBreakerService.getClass().getName());
	     return "Check logs for proxy class name";
	 }
	
}
