package com.multithreading.Multithreading.Concept.DeadLock;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	 private final InventoryService inventoryService;

	    public OrderService(@Lazy InventoryService inventoryService) {
	        this.inventoryService = inventoryService;
	    }
	    
	    public synchronized void placeOrder(String threadname) {
	    	    System.out.println(threadname+" "+" enter into placeorder method");
	        sleep(5000);
	        inventoryService.reserveStock(threadname);
	    }

	    private void sleep(long ms) {
	        try {
	            Thread.sleep(ms);
	        } catch (InterruptedException ignored) {}
	    }
	    
	    public synchronized void validateOrder() {
	        // dummy method
	    }
}
