package com.java.practice.JavaPractice.javaGeneric;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo {

	public static void main(String[] args) {
	
		// before java 5
		List list = new ArrayList();
		list.add("Sonu");
		list.add(10);   // allowed 😬

		//String name = (String) list.get(1); // 💥 ClassCastException at runtime
		//System.out.println(name);
		
		/*
		 * Ugly casting everywhere
		 */
		
		//-----------after genric
		
		List<String> list1 = new ArrayList<>();
		list1.add("Sonu");
		// list.add(10); ❌ compile-time error

		String name1 = list1.get(0); // no cast
		System.out.println(name1);
		
		/*
		 * Compile-time safety, No casting
		 * Generics move errors from runtime → compile time
		 */
		
		//--------------Type Erasur 
		
		List<String> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();

		System.out.println(l1.getClass() == l2.getClass()); // true
		
		/*
		 * Generics DO NOT exist at runtime in Java
		 * They are a compile-time feature only
		 * Type Erasure = The compiler removes generic type information and replaces it with:
            Object OR the upper bound (if bounds are used)
            mean as we declare List as List<String> and List<Integer> but after compilation
            java store it in .class file List l1, and List l2
            
            if compiler remove List<String> to list how it manage type safty:-
            when we fetch data from list like l1.get(0) compiler convert it into
            String s = (String) list.get(0); // compiler inserts cast
            # You don’t see casts, But JVM still needs them
		 */
	}

}
