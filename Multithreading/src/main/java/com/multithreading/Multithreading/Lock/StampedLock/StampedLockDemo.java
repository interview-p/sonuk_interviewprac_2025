package com.multithreading.Multithreading.Lock.StampedLock;

public class StampedLockDemo {

	 public static void main(String[] args) {

	        StampedCache cache = new StampedCache();

	        Runnable reader = cache::optimisticRead;
	        Runnable writer = () -> cache.write("updated");

	        new Thread(reader, "Reader-1").start();
	        new Thread(reader, "Reader-2").start();
	        new Thread(writer, "Writer").start();
	        new Thread(reader, "Reader-3").start();
	    }
	 
}
