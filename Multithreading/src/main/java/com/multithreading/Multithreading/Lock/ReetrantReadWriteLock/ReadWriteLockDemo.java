package com.multithreading.Multithreading.Lock.ReetrantReadWriteLock;

public class ReadWriteLockDemo {

	 public static void main(String[] args) {

	        Cache cache = new Cache();

	        // Readers
	        Runnable reader = cache::read;

	        // Writer
	        Runnable writer = () -> cache.write("new-data");

	        new Thread(reader, "Reader-1").start();
	        new Thread(reader, "Reader-2").start();
	        new Thread(writer, "Writer-1").start();
	        new Thread(reader, "Reader-3").start();
	    }
	 
}
