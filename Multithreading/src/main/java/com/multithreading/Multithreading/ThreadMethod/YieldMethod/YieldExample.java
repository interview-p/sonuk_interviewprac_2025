package com.multithreading.Multithreading.ThreadMethod.YieldMethod;

public class YieldExample {

	 public static void main(String[] args) {

	        Thread t1 = new Thread(() -> {
	            for (int i = 0; i < 5; i++) {
	                System.out.println("T1 running");
	                Thread.yield();
	            }
	        });

	        Thread t2 = new Thread(() -> {
	            for (int i = 0; i < 5; i++) {
	                System.out.println("T2 running");
	            }
	        });

	        t1.start();
	        t2.start();
	    }
	 
	 //  here when we use thread.yield() inside t1 jvm send signle to schedular 
	 // to get chance t2 to run i am ok to wait some time
}
