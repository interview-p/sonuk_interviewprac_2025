package com.multithreading.Multithreading.Concept.Bad_Starvation;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CorrectStartOrderService {

	 private final ReentrantLock lock = new ReentrantLock(true); // 1️⃣ fair lock

	    @Qualifier("fastExecutor")
	    private final Executor fastExecutor;

	    @Qualifier("slowExecutor")
	    private final Executor slowExecutor;

	    public CorrectStartOrderService(@Qualifier("fastExecutor") Executor fastExecutor,
	                        @Qualifier("slowExecutor") Executor slowExecutor) {
	        this.fastExecutor = fastExecutor;
	        this.slowExecutor = slowExecutor;
	    }

	    // FAST TASK
	    public void placeOrder() {
	        fastExecutor.execute(() -> {
	            try {
	                if (lock.tryLock(200, TimeUnit.MILLISECONDS)) { // 4️⃣ timeout
	                    try {
	                        System.out.println("Order placed by " + Thread.currentThread().getName());
	                        Thread.sleep(50);
	                    } finally {
	                        lock.unlock();
	                    }
	                } else {
	                    System.out.println("Order retry later");
	                }
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }

	            Thread.yield(); // 2️⃣ avoid hogging CPU
	        });
	    }

	    // SLOW TASK
	    public void generateReport() {
	        slowExecutor.execute(() -> {
	            try {
	                if (lock.tryLock(500, TimeUnit.MILLISECONDS)) {
	                    try {
	                        System.out.println("Generating report...");
	                        Thread.sleep(5000);
	                    } finally {
	                        lock.unlock();
	                    }
	                }
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        });
	    }
}
