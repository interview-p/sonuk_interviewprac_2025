package com.multithreading.Multithreading.ThreadMethod.SpuriousDemo;

public class SpuriousBug {

	 static boolean ready = false;
	    static final Object lock = new Object();

	    public static void main(String[] args) throws Exception {

	        Thread worker = new Thread(() -> {
	            synchronized (lock) {
	                if (!ready) {
	                    try {
	                        System.out.println("Waiting...");
	                        lock.wait();
	                        System.out.println("Woke up, checking...");
	                    } catch (InterruptedException e) {}
	                }
	                System.out.println("Ready value == "+ready);
	     	       System.out.println("using resources");
	            }
	        });

	        worker.start();

	    }
}
