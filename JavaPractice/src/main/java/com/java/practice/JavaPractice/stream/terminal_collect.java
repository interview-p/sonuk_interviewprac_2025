package com.java.practice.JavaPractice.stream;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class terminal_collect {

	public static void main(String[] args) {
		//collect() is used to accumulate elements of a stream into a container like 
		//a List, Set, Map, or even a custom object.
		/*
collection of data into multiple way ---
        
		To List	Collectors.toList()
		To Set	Collectors.toSet()
		To Map	Collectors.toMap(keyMapper, valueMapper)
		Grouping	 - Collectors.groupingBy(...) use with collectors.counting,collectors.mapping()
		Counting	 - Collectors.counting()
		Joining Strings	- Collectors.joining(", ")
		Summarizing Int	 - Collectors.summarizingInt(...)
		Averaging	 - Collectors.averagingInt(...)
		*/
		
		/*
		 * 
		 * 
How Collection.groupingby() work------------------

1. As per expresion result considered as key and if that condition satiesfied element goes into one bucket(list)
   another element comes and if condition not saties create new bucket if satiesfiled it goes to previous bucket
    
taking example of grouped2 in fun1()-----

Initialize an empty Map<Key, List<Value>>
For each element in the stream:
Compute key using the function (w -> w.charAt(0))
If key is not present, create a new list
Add element to the list for that key
Return the map when the stream ends
		
		*/
	
/*
 ----How Collector.partitioningBy() work internally-------
 
partitioningBy() is a special case of grouping.
It splits (partitions) elements into two groups only:
true group
false group
The key is always a boolean condition (Predicate).(logic we apply alway be return true)
So the result is always a Map<Boolean, List<T>> (or another type if you use a downstream collector).


*/
		

		terminal_collect obj = new terminal_collect();
		obj.fun1();
		//obj.fun2();
		
	}
	
	public void fun1() {
		
		// collect data into map
		
		List<String> words = List.of("apple", "banana", "cherry");

		Map<String, Integer> map = words.stream()
		        .collect(Collectors.toMap(
		            w -> w,       // key
		            w -> w.length()  // value
		        ));

		System.out.println("------1------- = "+map);
		
		
		// collect into group 
		
		List<String> word = List.of("apple", "ant", "banana", "bat");

		Map<Character, List<String>> grouped2 = word.stream()
		        .collect(Collectors.groupingBy(w -> w.charAt(0)));
		
		System.out.println("-------------------2----------- = "+grouped2);
		
		Map<Object, Long> grouped3 = word.stream()
		        .collect(Collectors.groupingBy(w -> w.charAt(0),Collectors.counting()));

		System.out.println("-------------------3----------- = "+grouped3);
		
		Map<Object, String> grouped4 = word.stream()
		        .collect(Collectors.groupingBy(w -> w.charAt(0),Collectors.joining(" ")));
		
		System.out.println("-------------------4----------- = "+grouped4);
		
		Map<Object, List<Object>> grouped5 = word.stream()
		        .collect(Collectors.groupingBy(w -> w.charAt(0),Collectors.mapping(x->x.length(), Collectors.toList())));
		
		System.out.println("-------------------5----------- = "+grouped5);
		
		List<Integer> al = List.of(1,2,3,2,4,6,2,1,3,1);
		
		Map<Object, Long> g1 = al.stream()
				                 .filter(x->x%2==0)
				                 .collect(Collectors.groupingBy(y->y,Collectors.counting()));
		
		System.out.println("---------------6------------- = "+g1);
		
		Optional<Integer> g2 = al.stream()
				       .collect(Collectors.groupingBy(y->y,Collectors.counting()))
				       .entrySet().stream()
				       .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
				       .map(x->x.getKey())
				       .findFirst();
		System.out.println("---------------7------------ = "+g2);
				                     
	}
	
	public void fun2() {
		
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

		Map<Boolean, List<Integer>> partitioned1 = numbers.stream()
		        .collect(Collectors.partitioningBy(n -> n % 2 == 0));

		System.out.println(partitioned1);
		
		//further downstreaming
		
		Map<Boolean, Long> partitioned2 = numbers.stream()
		        .collect(Collectors.partitioningBy(n -> n % 2 == 0,Collectors.counting()));

		System.out.println(partitioned2);
		
		Map<Boolean, Long> partitioned3 = numbers.stream()
		        .collect(Collectors.partitioningBy(n -> n % 2 == 0,Collectors.summingLong(Integer::intValue)));
		
		System.out.println(partitioned3);
		
	}

}
