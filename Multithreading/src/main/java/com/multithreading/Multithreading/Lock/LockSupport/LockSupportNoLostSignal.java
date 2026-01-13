package com.multithreading.Multithreading.Lock.LockSupport;

import java.util.concurrent.locks.LockSupport;

public class LockSupportNoLostSignal {


    static Thread waiter;

    public static void main(String[] args) throws Exception {

        waiter = new Thread(() -> {
            System.out.println("Waiter: parking");
            LockSupport.park();   // 😴 sleeps
            System.out.println("Waiter: resumed");
        });

        Thread notifier = new Thread(() -> {
            System.out.println("Notifier: unparking waiter");
            LockSupport.unpark(waiter);  // 📝 signal stored
        });

        notifier.start();
        Thread.sleep(100); // notifier runs first
        waiter.start();
    }
    
}
