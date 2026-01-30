package com.java.practice.JavaPractice.collection.queue;

import java.util.PriorityQueue;

public class priorityqueue {

	public static void main(String[] args) {
		
		 PriorityQueue<Integer> pq = new PriorityQueue<>();

	        // add elements
	        pq.add(10);
	        pq.add(90);
	        pq.add(20);
	        pq.add(40);
	        pq.add(100);
	        pq.add(40);
	        pq.add(79);
	        pq.add(65);
	        pq.add(120);
	        pq.add(50);
	        pq.add(30);

	      
	        // polling elements (sorted order)
	        while (!pq.isEmpty()) {
	            System.out.print(pq.poll() + " ");
	        }
	        
	        for (Integer value : pq) {
	            System.out.print(value + " ");
	        }
	        //10 30 20 65 40 40 79 90 120 100 50 
	}
}
