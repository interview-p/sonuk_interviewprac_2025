package com.multithreading.Multithreading.classLevelLock;

public class TestClassLockandObjectLock {
	 public static void main(String[] args) {

		 classLockandObjectLock d1 = new classLockandObjectLock();
		 classLockandObjectLock d2 = new classLockandObjectLock();

	        new Thread(d1::instanceLock, "T1").start();
	        new Thread(d2::instanceLock, "T2").start(); // runs in parallel ✅

	        // print message simutanously no thread wait 
	        
	        //new Thread(classLockandObjectLock::classLock, "T3").start();
	        //new Thread(classLockandObjectLock::classLock, "T4").start();  // blocks ❌
	        
	        // here T3 print message first than hold for 5 sec once it release lock 
	        // t4 print message it's mean when lock apply other thread not entered
	        
	    }
}
