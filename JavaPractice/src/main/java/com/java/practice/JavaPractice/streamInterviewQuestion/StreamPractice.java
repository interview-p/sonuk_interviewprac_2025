package com.java.practice.JavaPractice.streamInterviewQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.util.comparator.Comparators;

public class StreamPractice {

	public static void main(String[] args) {
		
		List<Integer> al = new ArrayList<>(Arrays.asList(1,2,3,65,34,9,0,56,34,87,23,67,1,2,3,56));
		
		List<Integer> el = al.stream().filter(x->x%2==0).collect(Collectors.toList());
		System.out.println("even no = "+el);
		
		// find dupliacate-----------
		Set<Integer> st = new HashSet<>();
		List<Integer> dl = al.stream().filter(x->!st.add(x)).toList();
		System.out.println("duplicate no = "+dl);
		
		
		// find frequency------------
		Map<Object, Long> fl = al.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
		System.out.println("frequency no = "+fl);
		
		// first non repeated element ------
		Set<Integer> st1 = new HashSet<>();
		Optional<Object> nl = fl.entrySet().stream().filter(x->x.getValue()==1).map(x->x.getKey()).findFirst();
		System.out.println("non repeated no = "+nl.orElse("NA"));
		
		// max element ------
		Optional ml = al.stream().sorted(Comparators.comparable().reversed()).findFirst();
		System.out.println("max element = "+ml.get());
		
		//convert list to map
		Map<Object, Object> lm = al.stream().collect(Collectors.toMap(x->x, x->x,(a,b)->a));
		System.out.println("convert list to map = "+lm);
		
		// flat char of array
		List<String> words = List.of("cat","dog");
		List<String> dlp = words.stream().flatMap(x->x.chars().mapToObj(y->String.valueOf((char)y))).distinct().sorted().toList();
		System.out.println("flatten array of string = "+dlp);
	
	}

}
