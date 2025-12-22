package com.multithreading.Multithreading.Concept.DeadLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;


@Service
public class OrderService_reetrantLock {

	 private final InventoryService_reetrantLock inventoryService;
	    private final ReentrantLock orderLock = new ReentrantLock();

	    public OrderService_reetrantLock(@Lazy InventoryService_reetrantLock inventoryService) {
	        this.inventoryService = inventoryService;
	    }

	    public void placeOrder() {
	        boolean orderLocked = false;
	        try {
	            orderLocked = orderLock.tryLock(500, TimeUnit.MILLISECONDS);
	            if (!orderLocked) {
	                retry("OrderService");
	                return;
	            }

	            Thread.sleep(5000);
	            inventoryService.reserveStock();

	        } catch (Exception e) {
	            Thread.currentThread().interrupt();
	        } finally {
	            if (orderLocked) orderLock.unlock();
	        }
	    }

	    public void validateOrder() {
	        boolean orderLocked = false;
	        try {
	            orderLocked = orderLock.tryLock(500, TimeUnit.MILLISECONDS);
	            if (!orderLocked) return;
	        } catch (Exception e) {
	            Thread.currentThread().interrupt();
	        } finally {
	            if (orderLocked) orderLock.unlock();
	        }
	    }

	    private void retry(String service) {
	        System.out.println("Retrying " + service);
	    }
}
