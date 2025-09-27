package com.java.practice.JavaPractice.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class intermediate_sort {

	public static void main(String[] args) {
		
		intermediate_sort obj = new intermediate_sort();
		
		obj.fun2();
	}
	
	public void fun1() {
		List<String> words = List.of("java", "spring", "ai", "microservices");
		
		List<String> al1 = words.stream()
				                .sorted(Comparator.comparingInt(s->s.length()))
				                .toList();
		System.out.println("sorted array = "+al1);
	}
	
	public void fun2() {
		
		List<String> words = List.of("apple", "banana", "apple", "orange", "banana", "apple");
		
		List<String> al1 = words.stream()
				                .collect(Collectors.groupingBy(x->x,Collectors.counting()))
				                .entrySet().stream()
				                .sorted(Comparator.comparingDouble(x->((Entry<String, Long>) x).getValue()).reversed())
				                .map(x->x.getKey())
				                .toList();
		
		System.out.print("sorted in decending order = "+al1);
		
		List<Integer> nums = List.of(5, 2, 9, 1, 7, 6);
		
		List<Integer> top3 = nums.stream()
		        .sorted(Comparator.reverseOrder())
		        .peek(n->System.out.println("peeking element = "+n))
		        .skip(1)
		        .limit(3)
		        .toList();

		System.out.println("sort reverse peek skip and limit = "+top3); // [9, 7, 6]
	}

}
