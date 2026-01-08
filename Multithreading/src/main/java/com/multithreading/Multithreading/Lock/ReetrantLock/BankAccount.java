package com.multithreading.Multithreading.Lock.ReetrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

	  // FAIR lock (FIFO order)
    private final ReentrantLock lock = new ReentrantLock(true);

    private int balance = 100;

    public void withdraw(String threadName, int amount) {

        try {
            // try to acquire lock within 2 seconds
            if (lock.tryLock(2, TimeUnit.SECONDS)) {
                try {
                    System.out.println(threadName + " acquired lock");

                    if (balance >= amount) {
                        Thread.sleep(1000); // simulate processing
                        balance -= amount;
                        System.out.println(threadName +
                                " withdrew " + amount +
                                ", balance=" + balance);
                    } else {
                        System.out.println(threadName +
                                " insufficient balance");
                    }
                } finally {
                    lock.unlock();
                    System.out.println(threadName + " released lock");
                }
            } else {
                // timeout happened
                System.out.println(threadName +
                        " could NOT acquire lock (timeout)");
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    // suppose T1 and T2 come at same time than T3 come T1 acquire lock and goes sleep for
    // 1 sec and it totally take less than 2 sec time  than T2 wait 2 sec and try once
    // now lock is free so T2. T2 acruire lock and T3 come immedintly after t2 it not
    // able to acquire lock bcoz tryLock() method return false because 2 sec already lapse than T3
    // try
}
