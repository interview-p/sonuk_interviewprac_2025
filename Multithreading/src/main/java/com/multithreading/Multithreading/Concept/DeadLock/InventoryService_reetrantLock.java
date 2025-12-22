package com.multithreading.Multithreading.Concept.DeadLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class InventoryService_reetrantLock {

	 private final OrderService_reetrantLock orderService;
	    private final ReentrantLock inventoryLock = new ReentrantLock();

	    public InventoryService_reetrantLock(@Lazy OrderService_reetrantLock orderService) {
	        this.orderService = orderService;
	    }

	    public void reserveStock() {
	        boolean inventoryLocked = false;
	        try {
	            inventoryLocked = inventoryLock.tryLock(500, TimeUnit.MILLISECONDS);
	            if (!inventoryLocked) {
	                retry("InventoryService");
	                return;
	            }

	            Thread.sleep(5000);
	            orderService.validateOrder();

	        } catch (Exception e) {
	            Thread.currentThread().interrupt();
	        } finally {
	            if (inventoryLocked) inventoryLock.unlock();
	        }
	    }

	    private void retry(String service) {
	        System.out.println("Retrying " + service);
	    }
	    
}
