package com.java.practice.JavaPractice.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class intermediate_flatmap {

	public static void main(String[] args) {
		
		intermediate_flatmap obj = new intermediate_flatmap();
		//obj.fun1();
		obj.fun2();
		
	}
	
	public void fun1() {
		List<List<Integer>> nested = List.of(
			    List.of(1, 2),
			    List.of(3, 4),
			    List.of(5)
			);
		
		//conclude all element in one list
		
		List<Integer> al = nested.stream().flatMap(x->x.stream()).toList();	
		List<Stream<Integer>> al1 = nested.stream().map(List::stream).toList();

		// when we do the same thing using map(List::stream) it return stream<stream<Integer>>
		
		System.out.println("flaten list of list in single list = "+al);
		
		//-----------------------------
		List<Map<String, String>> listOfMaps = List.of(
			    Map.of("a", "apple", "b", "banana"),
			    Map.of("c", "cherry", "d", "date"),
			    Map.of("e", "elderberry")
			);
		
		List<String> al3 = listOfMaps.stream().flatMap(x->x.keySet().stream()).toList();
		
		System.out.println("flaten list of map in single list = "+al3);
		
		//--------------------------------
		List<String> sentences = List.of("Java is fun", "Streams are powerful");
		
		List<Character> al4 = sentences.stream()
				                    .flatMap(x->Arrays.stream(x.split(" ")))
				                    .flatMap(x->x.chars().mapToObj(y->(char)y))
				                    .toList();
		
		System.out.println("split world in character = "+al4);
		
	}
	
	public void fun2() {
		
		//Cartesian Product (Pairs from 2 lists)
		
		List<Integer> list1 = List.of(1, 2, 3);
		List<Integer> list2 = List.of(4, 5);
		
		List<List<String>> al1 = list1.stream()
				                 .flatMap(x->list2.stream().map(y->List.of(y+" "+x)))
				                 .toList();
		
		System.out.println("cartesian product = "+al1);
	}
}
