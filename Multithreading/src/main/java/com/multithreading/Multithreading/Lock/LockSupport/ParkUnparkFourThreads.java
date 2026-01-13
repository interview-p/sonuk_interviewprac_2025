package com.multithreading.Multithreading.Lock.LockSupport;

import java.util.concurrent.locks.LockSupport;

public class ParkUnparkFourThreads {

	 static Thread t1, t2, t3, t4;

	    public static void main(String[] args) throws Exception {

	        // ---------------- T1 ----------------
	        t1 = new Thread(() -> {
	            System.out.println("T1: parking (no permit)");
	            LockSupport.park();
	            System.out.println("T1: resumed");
	        }, "T1");

	        // ---------------- T2 ----------------
	        t2 = new Thread(() -> {
	            sleep(1000);
	            System.out.println("T2: unparking T1");
	            LockSupport.unpark(t1);
	        }, "T2");

	        // ---------------- T3 ----------------
	        t3 = new Thread(() -> {
	            System.out.println("T3: unpark itself BEFORE park");
	            LockSupport.unpark(Thread.currentThread());

	            sleep(1000);
	            System.out.println("T3: parking (permit already available)");
	            LockSupport.park();

	            System.out.println("T3: resumed immediately");
	        }, "T3");

	        // ---------------- T4 ----------------
	        t4 = new Thread(() -> {
	            System.out.println("T4: calling unpark twice on itself");
	            LockSupport.unpark(Thread.currentThread());
	            LockSupport.unpark(Thread.currentThread());

	            sleep(1000);
	            System.out.println("T4: parking first time");
	            LockSupport.park();

	            System.out.println("T4: parking second time (will block)");
	            LockSupport.park();

	            System.out.println("T4: resumed again");
	        }, "T4");

	        // Start all threads
	        t1.start();
	        t2.start();
	        t3.start();
	        t4.start();

	        // Wake T4 second time
	        Thread.sleep(3000);
	        System.out.println("MAIN: unparking T4 again");
	        LockSupport.unpark(t4);
	    }

	    static void sleep(long ms) {
	        try {
	            Thread.sleep(ms);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    /*
	     T1: parking (no permit)
T3: unpark itself BEFORE park
T4: calling unpark twice on itself
T3: parking (permit already available)
T3: resumed immediately
T4: parking first time
T2: unparking T1
T1: resumed
T4: parking second time (will block)
MAIN: unparking T4 again
T4: resumed again


starting All threads: permit = 0

T1
T1 calls park()
permit = 0 → thread SLEEPS

T2
T2 sleeps 1 sec
T2 calls unpark(T1)
→ T1.permit = 1
→ OS wakes T1

T1 resumes
park() consumes permit
permit = 0
T1 continues

T3 (order-independent behavior)
T3 unpark itself
→ T3.permit = 1

T3 later calls park()
→ sees permit
→ consumes permit
→ DOES NOT BLOCK

T4 (permit does NOT accumulate)
unpark()
permit = 1
unpark()
permit = STILL 1 (no increase)



park() → consumes permit → continues
park() → permit = 0 → BLOCKS

main thread unpark(T4)
→ permit = 1
→ T4 resumes
	     */
}
