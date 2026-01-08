package com.multithreading.Multithreading.Async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class PaymentService_notwork {

	 public void processPayment() {
	        System.out.println("Thread before async: " + Thread.currentThread().getName());

	        // ❌ Self-invocation
	        asyncTask();
	    }

	    @Async
	    public void asyncTask() {
	        System.out.println("Async thread: " + Thread.currentThread().getName());
	    }
}
