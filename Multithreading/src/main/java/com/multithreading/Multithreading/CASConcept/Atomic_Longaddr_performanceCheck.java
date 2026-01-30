package com.multithreading.Multithreading.CASConcept;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Atomic_Longaddr_performanceCheck {

	 static final int THREADS = 8;
	 static final int INCREMENTS_PER_THREAD = 10000000;
	    
	public static void main(String[] args) throws Exception {
		
		 runAtomicLong();
	     System.out.println("-----------------------------");
	     runLongAdder();
	}
	
	 static void runAtomicLong() throws Exception {
	        AtomicLong counter = new AtomicLong();
	        CountDownLatch latch = new CountDownLatch(THREADS);

	        long start = System.currentTimeMillis();

	        for (int i = 0; i < THREADS; i++) {
	            new Thread(() -> {
	                for (int j = 0; j < INCREMENTS_PER_THREAD; j++) {
	                    counter.incrementAndGet();
	                }
	                latch.countDown();
	            }).start();
	        }

	        latch.await();
	        long end = System.currentTimeMillis();

	        System.out.println("AtomicLong value = " + counter.get());
	        System.out.println("AtomicLong time  = " + (end - start) + " ms");
	    }

	    static void runLongAdder() throws Exception {
	        LongAdder counter = new LongAdder();
	        CountDownLatch latch = new CountDownLatch(THREADS);

	        long start = System.currentTimeMillis();

	        for (int i = 0; i < THREADS; i++) {
	            new Thread(() -> {
	                for (int j = 0; j < INCREMENTS_PER_THREAD; j++) {
	                    counter.increment();
	                }
	                latch.countDown();
	            }).start();
	        }

	        latch.await();
	        long end = System.currentTimeMillis();

	        System.out.println("LongAdder value = " + counter.sum());
	        System.out.println("LongAdder time  = " + (end - start) + " ms");
	    }

}
