package com.multithreading.Multithreading.Concept.LiveLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

	 private final OrderService orderService;
	    private final ReentrantLock inventoryLock = new ReentrantLock();

	    public InventoryService(@Lazy OrderService orderService) {
	        this.orderService = orderService;
	    }

	    public void reserveStock() throws InterruptedException {
	        boolean inventoryLocked = false;

	        try {
	            // STEP 4: acquire inventory lock
	            inventoryLocked = inventoryLock.tryLock(200, TimeUnit.MILLISECONDS);
	            if (!inventoryLocked) {
	                throw new RetryableException("Inventory busy");
	            }

	            orderService.validateOrder();

	        } finally {
	            if (inventoryLocked) {
	                inventoryLock.unlock();
	            }
	        }
	    }
}
