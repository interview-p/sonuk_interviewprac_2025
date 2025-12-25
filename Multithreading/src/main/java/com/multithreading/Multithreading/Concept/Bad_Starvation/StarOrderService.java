package com.multithreading.Multithreading.Concept.Bad_Starvation;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.stereotype.Service;

@Service
public class StarOrderService {

	  private final ReentrantLock lock = new ReentrantLock(); // ❌ unfair
	    private final ExecutorService executor = Executors.newFixedThreadPool(2); // ❌ single pool

	    public void placeOrder() {
	        executor.submit(() -> {
	            while (true) { // ❌ infinite loop
	                lock.lock();
	                try {
	                    System.out.println("Fast order processing");
	                    Thread.sleep(50);
	                } catch (InterruptedException e) {
	                    Thread.currentThread().interrupt();
	                } finally {
	                    lock.unlock();
	                }
	            }
	        });
	    }

	    public void generateReport() {
	        executor.submit(() -> {
	            lock.lock();
	            try {
	                System.out.println("Generating report...");
	                Thread.sleep(10_000); // ❌ long task hogs lock
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            } finally {
	                lock.unlock();
	            }
	        });
	    }
}
