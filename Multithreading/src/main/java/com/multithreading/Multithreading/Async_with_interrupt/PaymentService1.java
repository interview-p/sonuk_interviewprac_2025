package com.multithreading.Multithreading.Async_with_interrupt;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class PaymentService1 {
	@Async("paymentExecutor")
    public void processPayment(String orderId) {
        System.out.println("Started payment: " + orderId);

        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(1000);
                System.out.println("Processing " + orderId);
            }
        } catch (InterruptedException e) {
            // restore interrupt flag
            Thread.currentThread().interrupt(); // re-interrupt
        	   //processPayment(orderId);
        }

        System.out.println("Payment task interrupted. Cleaning up...");
        cleanup(orderId);
    }

    private void cleanup(String orderId) {
        System.out.println("Releasing resources for " + orderId);
    }
}
