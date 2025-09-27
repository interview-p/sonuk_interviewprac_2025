package com.java.practice.JavaPractice.stream;

import java.util.List;

public class terminal_reduce {

	public static void main(String[] args) {
		
		//Think of reduce() as a way to combine all elements of a stream into a single
		//value.

		terminal_reduce obj = new terminal_reduce();
		
	}
	
	public void fun1() {
		
		List<Integer> numbers = List.of(1,2,3,34,5);
		
		int sumSquares = numbers.stream()
		        .map(n -> n * n)
		        .reduce(0, Integer::sum);
	}

}
