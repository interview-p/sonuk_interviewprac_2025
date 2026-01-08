package com.multithreading.Multithreading.ThreadMethod.JoinMethod;

public class JoinExample {
	 public static void main(String[] args) throws Exception {

	        Thread worker = new Thread(() -> {
	            System.out.println("Worker started");
	            try { Thread.sleep(2000); } catch (Exception e) {}
	            System.out.println("Worker finished");
	        });

	        worker.start();

	        System.out.println("Main waiting...");
	        worker.join();   // ⬅ wait here .here when worker.join() execute main thread
	                        // stop further line execution it only execute when worker thread completed
	        System.out.println("Main resumed");
	    }
}
