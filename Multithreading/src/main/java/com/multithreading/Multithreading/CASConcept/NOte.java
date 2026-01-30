package com.multithreading.Multithreading.CASConcept;

public class NOte {

	/*
	 * 
contention => multiple thread are try to reach critical section at same time

CAS works best when:
single variable
short update
frequent reads
rare writes
Circuit breaker state matches this perfectly.

in case of circuitbreaker how CAS is benefitial:-

What happens under high contention?
Example:
100 threads fail at once
All try to open circuit
CAS ensures:
only one opens it
others see it open and skip
No lock queue. No thread parking.

---------------------------------------
 CAS for simple uncontended updates . Locks for complex structural changes
 Contention is the situation where multiple threads compete to read and modify the same shared memory at the same time, causing some updates to fail even though the operation itself is valid.
	
	
---------------------
Re-odering

below are example how jvm treat internally our code when volatile used or not used
1>---
volatile boolean flag = false;
flag = true;     // write
boolean x = flag; // read

what JVM insert
WRITE flag
WRITE_BARRIER   // flush to main memory

READ_BARRIER
READ flag

2>--
synchronized (lock) {
    shared = 42;
}

ACQUIRE LOCK
FULL_BARRIER
WRITE shared
FULL_BARRIER
RELEASE LOCK
	 */
}
