package com.multithreading.Multithreading.CASConcept;


public class FalseSharingDemo {

	static class Counters {
         volatile long x = 0;
        long p1, p2, p3, p4, p5, p6, p7;
         volatile long y = 0;
       //------------ use above once and below one execution time different  
         //volatile long x = 0;
         //long p1, p2, p3, p4, p5, p6, p7;
          //volatile long y = 0;
    }

    public static void main(String[] args) throws Exception {
        Counters c = new Counters();

        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 1_000_000_000L; i++) {
                c.x++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (long i = 0; i < 1_000_000_000L; i++) {
                c.y++;
            }
        });

        long start = System.currentTimeMillis();

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Time = " + (System.currentTimeMillis() - start));
    }
    
    /*
🧠 “Thread-1 updates x, Thread-2 updates y.
They are different variables, so no conflict.”
       
✔️ Logically correct
❌ Physically wrong at CPU level

This mismatch is where false sharing is born.

[ x ][ y ][ some other fields ][ padding ]

Core-1 cache → owns cache line (x,y)
Core-2 cache → cache line INVALID


observation:- let assume there are 4 core so when cpu load variable from memory in cache
of cpu it is come in chunk and continous manner as above given

mean if 4-core present every core have own copy of cache line 
so when thread-1 update x it write back to own cache line and sent one signal to
other core that your cache line is invalidate . in that when thread-2 try to update
variable Y it re-load data from memory again than update and send signal to other your 
cache line invalidate . in that case multiple CAS operation perform 

mean cpu wastege their time to run login instaed of loading data 

to solve this we use padding variable or LOngaddr or @contention
if we use padding variable due to this may be x come in core-1 cache line and y come
in core-2 cacheline . if variable comes in different cacheline of respective problem solve

using volatile with padding -> even not solve issue because if we use volatile it forse
jvm to re-load cachline every time which increase cpu execution time

here you just have to see execution time when volatile used when volatile not use
     */
}
