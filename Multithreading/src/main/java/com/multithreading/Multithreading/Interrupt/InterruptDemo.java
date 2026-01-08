package com.multithreading.Multithreading.Interrupt;

public class InterruptDemo {

	  public static void main(String[] args) throws Exception {

	        Thread worker = new Thread(() -> {
	            while (!Thread.currentThread().isInterrupted()) { //1. By checking interrupt flag manually 
	                System.out.println("Working...");
	                try {
	                    Thread.sleep(500); //✅ 2. By calling interruptible methods
	                } catch (InterruptedException e) {
	                    System.out.println("Interrupted during sleep");
	                    Thread.currentThread().interrupt(); // restore ✅ 3. By re-throwing or propagating interrupt
	                }
	            }
	            System.out.println("Gracefully stopped");
	        });

	        worker.start();

	        Thread.sleep(2000);
	        System.out.println("Requesting stop");
	        worker.interrupt();
	    }
	  
	  
	  /*
	   * we can stop another thread from other thread setting interrupt flag true for 
	   * that thread first check current thread interrupt flag than call any 
	   * inturrupt method like sleep(),wait() than this method throw interrupt exception
	   * we catch it print message than again set interrupt flag
	   */
}
