package com.java.practice.JavaPractice.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

public class practise {

	public static void main(String[] args) {
		
		List<Integer> ls1 = List.of(1,2,3,2,2,4,6,2,1,3,1);
		
		Optional<Object> a = ls1.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()))
		            .entrySet().stream()
		            .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
		            //.sorted(Comparator.comparingInt(x->((Entry<Integer, Integer>) x).getValue()).reversed())
		            .findFirst().map(x->x.getKey());
		
		System.out.print(a.orElse(null));

	}

}
