package com.java.practice.JavaPractice.FuntionalInterfaceDemo;

import java.util.ArrayList;
import java.util.List;

public class StreamConceptCheck {

	public static void main(String[] args) {
		
		Integer factor = 3;
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);list.add(87);list.add(98);list.add(12);
        
		list.stream()
		    .map(x -> x * factor)
		    .forEach(System.out::println);

	}

}
