package com.java.practice.JavaPractice.collection.queue;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {

	public static void main(String[] args) {
		
		PriorityBlockingQueue<Task> queue = new PriorityBlockingQueue<>();

		// Producer
		new Thread(() -> {
		    queue.put(new Task(1, "High priority"));
		    queue.put(new Task(5, "Low priority"));
		}).start();

		// Consumer
		new Thread(() -> {
		    try {
		        while (true) {
		            Task task = queue.take(); // waits if queue is empty
		            System.out.println("Processing " + task.name);
		        }
		    } catch (InterruptedException e) {}
		}).start();

	}

}
