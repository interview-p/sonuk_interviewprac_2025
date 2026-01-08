package com.multithreading.Multithreading.classLevelLock;

public class Demo {

	  public static void main(String[] args) {

	        DeadlockExample obj = new DeadlockExample();

	        // Thread T1
	        Thread t1 = new Thread(() -> {
	            obj.instanceMethod();
	        }, "T1");

	        // Thread T2
	        Thread t2 = new Thread(() -> {
	            /*synchronized (DeadlockExample.class) {   // CLASS LOCK
	                DeadlockExample.sleep(100);
	                obj.instanceMethod();                // OBJECT LOCK
	            }*/
	            
	            DeadlockExample.classMethod();
	        }, "T2");
	        
	        //  writing DeadlockExample.classMethod() is same above as given in t2

	        t1.start();
	        t2.start();
	    }
	  
}
