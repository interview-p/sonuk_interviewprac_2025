package com.multithreading.Multithreading.Concept.LiveLock;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	private final InventoryService inventoryService;
    private final ReentrantLock orderLock = new ReentrantLock();

    private static final int MAX_RETRIES = 5;

    public OrderService(@Lazy InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public void placeOrder() {

    	    //while(true)
        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {

            boolean orderLocked = false;

            try {
                // STEP 1: acquire order lock
                orderLocked = orderLock.tryLock(200, TimeUnit.MILLISECONDS);
                if (!orderLocked) {
                    backoff(attempt);
                    continue;
                }

                // STEP 2: reserve inventory
                inventoryService.reserveStock();

                System.out.println("Order placed successfully");
                return;

            } catch (RetryableException e) {
                // STEP 3: bounded retry with backoff
                backoff(attempt);
                //continue

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;

            } finally {
                if (orderLocked) {
                    orderLock.unlock();
                }
            }
        }

        throw new RuntimeException("Order failed after retries");
    }

    public void validateOrder() {
        boolean orderLocked = false;

        try {
            orderLocked = orderLock.tryLock(200, TimeUnit.MILLISECONDS);
            if (!orderLocked) {
                throw new RetryableException("Order busy");
            }

            Thread.sleep(50); // simulate work

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            if (orderLocked) {
                orderLock.unlock();
            }
        }
    }

    private void backoff(int attempt) {
        try {
            long delay = ThreadLocalRandom.current().nextLong(50, 200)
                         * attempt; // jitter + exponential backoff
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
