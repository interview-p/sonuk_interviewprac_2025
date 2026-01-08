package com.multithreading.Multithreading.ThreadMethod.SleepMethod;

public class SleepWithCpuLoad {

	  public static void main(String[] args) throws InterruptedException {

	        // Busy thread to hog CPU
		    //Add CPU pressure: make hog thread as deamon which mean this thread have high priority
	        Thread hog = new Thread(() -> {
	            while (true) {
	                // burn CPU
	            }
	        });
	        hog.setDaemon(true);
	        hog.start();

	        for (int i = 1; i <= 5; i++) {
	            long start = System.currentTimeMillis();

	            Thread.sleep(1000);

	            long end = System.currentTimeMillis();
	            System.out.println("Slept: " + (end - start) + " ms");
	        }
	    }
	  
	  /*
	  🔥 Same sleep request, bigger delay due to scheduler pressure.
	  */
}
