package com.multithreading.Multithreading.classLevelLock;

public class DeadlockExample {

	  // OBJECT-LEVEL LOCK (this)
    synchronized void instanceMethod() {
        System.out.println(Thread.currentThread().getName() +
                " entered instanceMethod");

        sleep(100);

        // tries to acquire CLASS-LEVEL LOCK
        classMethod();
    }

    // CLASS-LEVEL LOCK (DeadlockExample.class)
    static synchronized void classMethod() {
        System.out.println(Thread.currentThread().getName() +
                " entered classMethod");

        sleep(100);
    }

    static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
}
