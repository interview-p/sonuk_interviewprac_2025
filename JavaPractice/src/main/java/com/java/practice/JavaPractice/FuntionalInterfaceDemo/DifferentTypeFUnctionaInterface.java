package com.java.practice.JavaPractice.FuntionalInterfaceDemo;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DifferentTypeFUnctionaInterface {

	public static void main(String[] args) {
		
		Function<String, Integer> length =
		        s -> s.length();

		System.out.println(length.apply("Java"));
	//---------------------------------------------------	
		Consumer<String> print =
		        s -> System.out.println(s);

		print.accept("Hello");
	//---------------------------------------------------	
		Supplier<Double> random =
		        () -> Math.random();

		System.out.println(random.get());
		
		//-----------------------------------------------
		
		Predicate<Integer> isEven =
		        n -> n % 2 == 0;

		System.out.println(isEven.test(4));

	}
	
	

}
