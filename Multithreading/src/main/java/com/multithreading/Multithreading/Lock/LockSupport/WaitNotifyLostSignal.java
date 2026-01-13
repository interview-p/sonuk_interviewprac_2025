package com.multithreading.Multithreading.Lock.LockSupport;

public class WaitNotifyLostSignal {

	private static final Object lock = new Object();

    public static void main(String[] args) throws Exception {

        Thread notifier = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Notifier: sending notify");
                lock.notify();   // 🔔 notification sent
            }
        });

        Thread waiter = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("Waiter: waiting");
                    lock.wait();   // 😴 waits forever
                    System.out.println("Waiter: resumed");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        notifier.start();
        Thread.sleep(100); // ensure notifier runs first
        waiter.start();
    }
    
    /*
     here due to incorrect ordering of wait and notify waiter always waiting and thread
     never became destroy
     Deadlock caused by lost signal
    🧠 Why wait/notify fails
    notify() does NOT remember anything
    If no thread is waiting → signal disappears
    Order matters
    */
    
}
