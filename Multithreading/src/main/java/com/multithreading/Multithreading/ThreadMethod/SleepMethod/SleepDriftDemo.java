package com.multithreading.Multithreading.ThreadMethod.SleepMethod;

public class SleepDriftDemo {

	 public static void main(String[] args) throws InterruptedException {

	        for (int i = 1; i <= 5; i++) {
	            long start = System.currentTimeMillis();

	            Thread.sleep(1000); // request 1 second sleep

	            long end = System.currentTimeMillis();
	            System.out.println(
	                "Iteration " + i + " slept for " + (end - start) + " ms"
	            );
	        }
	    }
}
