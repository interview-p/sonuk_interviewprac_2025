package com.java.practice.JavaPractice.stream;

import java.util.List;

public class intermediate_mapM {

	public static void main(String[] args) {
		
		intermediate_mapM obj = new intermediate_mapM();
		obj.fun1();
	}

	public void fun1() {
		List<String> words = List.of("apple", "banana", "cherry");

		List<Integer> lengths = words.stream()
		        .filter(w -> w.contains("a"))  // filter first
		        .map(String::length)            // map to length
		        .toList();

		System.out.println(lengths);
	}
}
