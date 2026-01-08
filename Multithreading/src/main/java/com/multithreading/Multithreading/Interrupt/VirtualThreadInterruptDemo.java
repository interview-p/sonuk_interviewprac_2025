package com.multithreading.Multithreading.Interrupt;

public class VirtualThreadInterruptDemo {

	 public static void main(String[] args) throws Exception {

	        Thread vThread = Thread.startVirtualThread(() -> {
	            System.out.println("Virtual thread started: " +
	                    Thread.currentThread());

	            try {
	                while (!Thread.currentThread().isInterrupted()) {
	                    System.out.println("Working...");
	                    Thread.sleep(1000); // blocks (parks virtual thread)
	                }
	            } catch (InterruptedException e) {
	                // IMPORTANT: restore interrupt
	                Thread.currentThread().interrupt();
	                System.out.println("Interrupted during sleep");
	            }

	            System.out.println("Virtual thread exiting gracefully");
	        });

	        // Let it run for some time
	        Thread.sleep(3000);

	        System.out.println("Main thread interrupting virtual thread");
	        vThread.interrupt();

	        // Wait for virtual thread to finish
	        vThread.join();

	        System.out.println("Main thread finished");
	    }
}
