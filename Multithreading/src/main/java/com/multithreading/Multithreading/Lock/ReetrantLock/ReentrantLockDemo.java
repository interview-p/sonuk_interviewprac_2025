package com.multithreading.Multithreading.Lock.ReetrantLock;

public class ReentrantLockDemo {

	 public static void main(String[] args) {

	        BankAccount account = new BankAccount();

	        Runnable task = () -> {
	            String name = Thread.currentThread().getName();
	            account.withdraw(name, 50);
	        };

	        new Thread(task, "T1").start();
	        new Thread(task, "T2").start();
	        new Thread(task, "T3").start();
	    }
	 
}
