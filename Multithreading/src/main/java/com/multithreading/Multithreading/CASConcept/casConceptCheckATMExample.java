package com.multithreading.Multithreading.CASConcept;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class casConceptCheckATMExample {

	static AtomicInteger balance = new AtomicInteger(10000);

    static CountDownLatch startGate = new CountDownLatch(1);
    static CountDownLatch readGate  = new CountDownLatch(2);

    public static void main(String[] args) throws Exception {

        Runnable task = () -> {
            String name = Thread.currentThread().getName();
            int expected = 0;

            try {
                startGate.await();       // start together
                expected = balance.get();
                readGate.countDown();    // signal read done
                readGate.await();        // wait till both read
            } catch (Exception e) {}

            boolean success =
                    balance.compareAndSet(expected, expected - 6000);

            System.out.println(name +
                    " expected=" + expected +
                    " success=" + success +
                    " finalBalance=" + balance.get());
        };

        new Thread(task, "ATM-1").start();
        new Thread(task, "ATM-2").start();

        Thread.sleep(500);
        System.out.println("🚦 Opening gate!");
        startGate.countDown();
    }
    
    /*
      observation:-
      
      here we use countdownlatch which work like gatekeeper after waiting of 1000ms latch or gate open
      we use this because as per code ATM-1 always start first ATM-2 never get chance
      so countdonwlatch open the gate both thread come at same time . run multiple time you observed
      sometime ATM-1 sometime ATM-2 runfirst
      
      "🚦 Opening gate!
ATM-2 expected=10000 success=true finalBalance=4000
ATM-1 expected=10000 success=false finalBalance=4000
"

this is one of output here you can see ATM-2 come first and than ATM-1 both read balance is 10k 
when ATM-2 update the data first and get success is true same time ATM-1 read balance is 10k
but getting success is false not update to update .

 this is case mean when ATM-1 expecting 10k but not found same it reject to update the value
      
     */
	
	/*
	 CAS for simple uncontended updates . Locks for complex structural changes
	 Contention is the situation where multiple threads compete to read and modify the same shared memory at the same time, causing some updates to fail even though the operation itself is valid.
	 */
}
