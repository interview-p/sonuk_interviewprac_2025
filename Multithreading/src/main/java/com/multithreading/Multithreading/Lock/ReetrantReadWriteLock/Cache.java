package com.multithreading.Multithreading.Lock.ReetrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {

	private String data = "initial-data";

    private final ReentrantReadWriteLock rwLock =
            new ReentrantReadWriteLock(true); // fair lock for clarity

    // READ LOCK (multiple threads allowed)
    public String read() {
        rwLock.readLock().lock();
        try {
            System.out.println(
                Thread.currentThread().getName() +
                " READING -> " + data
            );
            sleep(1000);
            return data;
        } finally {
            rwLock.readLock().unlock();
        }
    }

    // WRITE LOCK (exclusive)
    public void write(String value) {
        rwLock.writeLock().lock();
        try {
            System.out.println(
                Thread.currentThread().getName() +
                " WRITING -> " + value
            );
            sleep(2000);
            data = value;
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    private void sleep(long ms) {
        try { Thread.sleep(ms); }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
}
