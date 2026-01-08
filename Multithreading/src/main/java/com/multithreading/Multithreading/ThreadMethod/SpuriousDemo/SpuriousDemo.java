package com.multithreading.Multithreading.ThreadMethod.SpuriousDemo;

public class SpuriousDemo {

	 static boolean ready = false;
	    static final Object lock = new Object();

	    public static void main(String[] args) throws Exception {

	        Thread worker = new Thread(() -> {
	            synchronized (lock) {
	                while (!ready) {
	                    try {
	                        System.out.println("Waiting...");
	                        lock.wait();
	                        System.out.println("Woke up, checking...");
	                    } catch (InterruptedException e) {}
	                }
	                System.out.println("Condition met, working!");
	            }
	        });

	        worker.start();

	        Thread.sleep(1000);

	        synchronized (lock) {
	            System.out.println("NOT notifying, just noise");
	            //lock.notify(); // pretend spurious wakeup
	        }

	        Thread.sleep(1000);

	        synchronized (lock) {
	            ready = true;
	            lock.notify();
	        }
	    }
}
