package com.multithreading.Multithreading.Lock.StampedLock;

import java.util.concurrent.locks.StampedLock;

public class StampedCache {

	 private String data = "initial";

	    private final StampedLock lock = new StampedLock();

	    // 1️⃣ OPTIMISTIC READ (no blocking)
	    public String optimisticRead() {
	        long stamp = lock.tryOptimisticRead(); // no lock taken
	        String result = data;

	        // simulate work
	        //sleep(1000);

	        // check if a writer modified data
	        if (!lock.validate(stamp)) {
	            // fallback to real read lock
	            stamp = lock.readLock();
	            try {
	                result = data;
	            } finally {
	                lock.unlockRead(stamp);
	            }
	        }

	        System.out.println(Thread.currentThread().getName()
	                + " READ -> " + result);
	        return result;
	    }

	    // 2️⃣ WRITE LOCK (exclusive)
	    public void write(String value) {
	        long stamp = lock.writeLock();
	        try {
	            System.out.println(Thread.currentThread().getName()
	                    + " WRITING -> " + value);
	            //sleep(2000);
	            data = value;
	        } finally {
	            lock.unlockWrite(stamp);
	        }
	    }

	    private void sleep(long ms) {
	        try { Thread.sleep(ms); }
	        catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }
	    
}
