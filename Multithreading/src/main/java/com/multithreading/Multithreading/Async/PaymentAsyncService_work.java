package com.multithreading.Multithreading.Async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class PaymentAsyncService_work {

	 @Async
	    public void asyncTask() {
	        System.out.println("Async thread: " + Thread.currentThread().getName());
	    }
}
