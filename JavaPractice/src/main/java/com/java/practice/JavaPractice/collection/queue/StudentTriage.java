package com.java.practice.JavaPractice.collection.queue;

import java.util.PriorityQueue;

public class StudentTriage {

	public static void main(String[] args) {

        PriorityQueue<Student> erQueue =
            new PriorityQueue<>((p1, p2) -> p2.severity - p1.severity);

        erQueue.add(new Student("Rahul", 2));   // normal
        erQueue.add(new Student("Anita", 5));   // serious
        erQueue.add(new Student("Suresh", 10)); // critical
        erQueue.add(new Student("Pooja", 3));   // moderate

        while (!erQueue.isEmpty()) {
        	Student p = erQueue.poll();
            System.out.println(
                "Treating patient: " + p.name +
                " (Severity: " + p.severity + ")"
            );
        }
    }
	
}
