package com.java.practice.JavaPractice.javaGeneric;

import java.util.ArrayList;
import java.util.List;

public class WildCardCheck {

	public static void main(String[] args) {
		
		
		Number nm = 89;
		System.out.println("number = "+nm);
		Integer inl = 90;
		nm = inl;
		System.out.println("number = "+nm);
		Double dbl = 89.7;
		nm= dbl;
		System.out.println("number = "+nm);
		
		List<Number> nmls = new ArrayList<>();
		List<Integer> in = new ArrayList<>();
		List<Double> dl = new ArrayList<>();
		
		nmls.add(new Integer(78));
		nmls.add(new Double(78.8));
		System.out.println("number list value = "+nmls);
		
		//nmls = in; // it is not possiable because in contain only list of integer and nmls is responsiable
		            // for both Integer and Double so it will accept List of integer assigment
		
		/*
		  that's why wildcard comes in 
		  their type:-
		  <?> - Unknown 
          <? extends T>	- T or subclass
          <? super T>	- T or superclass
		 */
		
		List<String> st = new ArrayList<>();
		st.add("sonu");
		print1(st);
		// here print1(List<?>) mean it can accept any thing List<Integer>, List<Double> 
		// because wild card say i don't know the type it accept any type
		
		
		// upper bound wild card
		List<Integer> st1 = new ArrayList<>();
		st1.add(10);
		List<Double> st2 = new ArrayList<>();
		st2.add(10.56);
		print2(st1);
		print2(st2);
		
		// in upper bound only it's SubType class are allow like in print2 method we extend 
		// Number it allow only Integer,Double not String
		
		// lower bound <? super T>
		List<Integer> st3 = new ArrayList<>();
		st3.add(10);
		List<Double> st4 = new ArrayList<>();
		st4.add(10.56);
		print3(st3);
		//print3(st4); // not allow because print3 allow only Integer superType like Number,Integer and Object only
		List<Number> st5 = new ArrayList<>();
		st5.add(78.65);
		print3(st5);
		
		// in lower bound like in print2 it super Integer so it accept only it's super class only
		// like Number,Object only

	}
	
	public static void print1(List<?> lst) {
		Object obj = lst.get(0);
		System.out.println("wild<?> value = "+obj);
	}
	
	public static void print2(List<? extends Number> lst) {
		Object obj = lst.get(0);
		System.out.println("wild<? subclass> value = "+obj);
		//lst.add(45); we can not add integer value bcoz it accept Number subtype which can be any so particulally we 
		// can not add integer 
		// we just read, do not write
	}
	
	public static void print3(List<? super Integer> lst) {
		Object obj = lst.get(0);
		//Integer obj1 = lst.get(0); // reading only applicable for object only because compiler don't know it's type
		lst.add(67);
		//lst.add("78.76"); // can not add double value
		
		System.out.println("wild<? super T> value = "+lst);
	}

}
