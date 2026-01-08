package com.multithreading.Multithreading.classLevelLock;

public class classLockandObjectLock {

	public synchronized void instanceLock() {
        System.out.println("Object lock: " + this);
        sleep();
    }
	
	// when we write as above jvm considered as instanceLock(this){}

    public static synchronized void classLock() {
        System.out.println("Class lock");
        sleep();
    }

    // when we write as above jvm considered as classLock{ synchronized(classLockandObjectLock.class)}
    static void sleep() {
        try { Thread.sleep(5000); }
        catch (InterruptedException e) {}
    }
    
}
