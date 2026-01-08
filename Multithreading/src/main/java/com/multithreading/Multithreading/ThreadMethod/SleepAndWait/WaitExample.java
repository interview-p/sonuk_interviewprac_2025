package com.multithreading.Multithreading.ThreadMethod.SleepAndWait;

public class WaitExample {

	 private static final Object lock = new Object();

	    public static void main(String[] args) {
	        Thread t1 = new Thread(() -> {
	            synchronized (lock) {
	                try {
	                    System.out.println("T1 got lock, waiting...");
	                    lock.wait(); // releases lock
	                    System.out.println("T1 resumed");
	                } catch (InterruptedException e) {}
	            }
	        });

	        Thread t2 = new Thread(() -> {
	            synchronized (lock) {
	                System.out.println("T2 got lock, notifying...");
	                lock.notify();
	            }
	        });

	        t1.start();
	        sleep(5000);
	        t2.start();
	    }

	    static void sleep(long ms) {
	        try { Thread.sleep(ms); } catch (InterruptedException e) {}
	    }
	    
	    /*
	     * here T1 got lock than goes into wait status and release lock on object than
	     * T2 got lock and notify once notify it wakup T1 thread and T1 thread start
	     * executing
	     */
}
