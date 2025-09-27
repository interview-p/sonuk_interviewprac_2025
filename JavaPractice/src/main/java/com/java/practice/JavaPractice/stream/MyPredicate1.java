package com.java.practice.JavaPractice.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyPredicate1 {

	public static <T> void main(String[] args) {
		
		MyPredicateInterface1<T> m1 = new MyPredicateInterface1<T>() {

			List<T> ak = new ArrayList<>();
			
			@Override
			public boolean checkanyElementstartWithS(List<T> at) {
				for(T al:at) {
					if(al.toString().startsWith("s")) {
						return true;
					}
				}
				return false;
			}
			
		};
		
		List<String> myList = Arrays.asList("apple", "strawberry", "banana", "sugar", "peach");
		
		boolean isResultFound = m1.checkanyElementstartWithS((List<T>) myList);
		
		System.out.println("is any element start with s = "+isResultFound);
		
	}
	
	
}
