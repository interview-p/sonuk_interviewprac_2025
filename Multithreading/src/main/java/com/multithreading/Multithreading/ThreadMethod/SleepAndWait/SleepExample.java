package com.multithreading.Multithreading.ThreadMethod.SleepAndWait;

public class SleepExample {

	 private static final Object lock = new Object();
	 
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("T1 got lock");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {}
                System.out.println("T1 woke up");
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("T2 got lock");
            }
        });

        t1.start();
        sleep(500);
        t2.start();
        
	}
	
	 static void sleep(long ms) {
	        try { Thread.sleep(ms); } catch (InterruptedException e) {}
	    }
	 
	 /*
	  * here T1 got lock than wakup than T2 got lock because
	  * when T1 goes into sleep status T1 not release lock on lock object when it wakup
	  * complete method execution than T2 got lock
	  */
	
}
