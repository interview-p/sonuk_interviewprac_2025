package com.java.practice.JavaPractice.stream;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class intermediate_filterM {

	public static void main(String[] args) {
		
		// filter use predicate mean it take input apply logic and return true false
		
		intermediate_filterM obj = new intermediate_filterM();
		//obj.filterexample1();
		//obj.filterexample2();
		obj.filterexample3();

	}
	
	public void filterexample1() {
		
		List<String> words = List.of("hello", "","java", " ");

        List<String> clean = words.stream()
                .filter(Objects::nonNull)    // remove nulls
                .filter(s -> !s.isBlank())   // remove empty/blank
                .toList();

        System.out.println(clean); // [hello, java]
        
	}
	
	public void filterexample2() {
		
		  List<Integer> nums = List.of(10, 20, 30, 40, 50);
		  
		  List<Integer> al = IntStream.range(0, nums.size())
				                      .filter(i->i%2==0)
				                      .mapToObj(nums::get)
				                      .toList();
		  
		  System.out.println("even index number = "+al);
	}
	
	public void filterexample3() {
		
		 List<String> items = List.of("apple", "banana", "apple", "cherry", "banana", "apple");
		 
		 List<String> al = items.stream()
				                .collect(Collectors.groupingBy(s->s,Collectors.counting())) // return hashMap
				                .entrySet().stream()
				                .filter(e->e.getValue()>1)
				                .map(Map.Entry::getKey)
				                .toList();
		 
		 System.out.println(al);
	}

}
