package com.multithreading.Multithreading.Concept.DeadLock;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

	 private final OrderService orderService;

	    public InventoryService(@Lazy OrderService orderService) {
	        this.orderService = orderService;
	    }

	    public synchronized void reserveStock(String threadname) {
	    	    System.out.println(threadname+" "+ "enter into reserveStock method");
	        sleep(5000);
	        orderService.validateOrder();
	    }

	    public synchronized void validateOrder() {
	        // dummy method
	    }

	    private void sleep(long ms) {
	        try {
	            Thread.sleep(ms);
	        } catch (InterruptedException ignored) {}
	    }
	    
	    
}
