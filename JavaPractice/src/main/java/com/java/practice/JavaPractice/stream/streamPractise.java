package com.java.practice.JavaPractice.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.util.comparator.Comparators;

public class streamPractise {

	public static void main(String[] args) {
	
		streamPractise obj = new streamPractise();
		
		//obj.fun1();
		//obj.fun2();
		obj.fun3();
		//obj.fun4();
		//obj.fun5();
		//obj.fun6();
		//obj.fun7();
	
}
	
	public void fun1() {
		
		// Find the second highest distinct number
		List<Integer> list = List.of(5, 9, 11, 9, 3, 7, 11, 8);
		Optional<Integer> a = list.stream()
		    .distinct()
		    .sorted(Comparator.reverseOrder())
		    .skip(1)
		    .findFirst();
		
		System.out.println("-----1------ ="+a);
		
		//Most frequent element
		List<Integer> ls1 = List.of(1,2,3,2,2,4,6,2,1,3,1);
		
		long a1 = ls1.stream()
		   .collect(Collectors.groupingBy(x->x,Collectors.counting()))
		   .entrySet().stream()
		   .max(Map.Entry.comparingByValue())
		   .map(x->x.getKey())
		   .orElseThrow();
		
		System.out.println("---------2----------- ="+a1);
		
		//Check if all elements are prime
		List<Integer> a2 = List.of(2,3,5,7,11);
		
		boolean a3 = a2.stream()
		  .allMatch(n->n>1 && IntStream.range(2, n).noneMatch(x->n%x==0));
		  
		System.out.println("---------3----------- ="+a3);
		
//		/Partition into even & odd
		List<Integer> a4 = List.of(1,2,3,4,5,6);
		
		Map<Boolean, List<Integer>> a5 = a4.stream()
				             .collect(Collectors.partitioningBy(x->x%2==0));
		
		System.out.println("---------4----------- ="+a5);
		
		//Longest string
		List<String> b1 = List.of("java", "spring", "microservices", "api");
		
		Optional<String> a6 = b1.stream().sorted(Comparator.comparingInt(String::length).reversed())
				                .findFirst();
		
		System.out.println("---------5----------- ="+a6);
		
		//count of Strings starting with vowel
		List<String> ch = List.of("a","e","i","o","u");
		List<String> b2 = List.of("apple", "banana", "orange", "grape", "ice");
		long a7 = b2.stream().filter(x->ch.contains(x.substring(0, 2))).peek(x->System.out.print(x+" ")).count();
		
		System.out.println("---------6----------- ="+a7);
		
		//Group words by length
		List<String> b3 = List.of("hi", "java", "spring", "go", "aws");
		
		Map<Integer, List<String>> a8 = b3.stream()
		        .collect(Collectors.groupingBy(String::length));
		
		
		System.out.println("----------7--------- ="+a8);
		
		//First non-repeated character
		String b4 = "swiss";
		Character a9 = b4.chars().mapToObj(c->(char)c)
				      .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
				      .entrySet().stream()
				      .filter(x->x.getValue()==1)
				      .map(x->x.getKey())
				      .findFirst()
				      .get();
		
		System.out.println("----------8--------- ="+a9);
		
	}
				            	
	
    public void fun2() {
		
    	record Employee(String name, String dept, double salary) {}
    	List<Employee> emps = List.of(
    		    new Employee("A", "IT", 70000),
    		    new Employee("B", "IT", 90000),
    		    new Employee("C", "HR", 50000),
    		    new Employee("D", "HR", 60000)
    		);

    	
    	//Highest paid employee per department
    	
    	Map<String, Object> al = emps.stream()
    			          .collect(Collectors.groupingBy(Employee::dept,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::salary)), Optional::get)));
      
    	 System.out.println("----------1--------- = "+al);
    	 
    List<Employee>	a2 = emps.stream()
    	    .collect(Collectors.toMap(Employee::dept,e->e,(e1,e2)->e1.salary>e2.salary?e1:e2))
    	    .entrySet().stream()
    	    .map(x->x.getValue())
    	    	.collect(Collectors.toList());
    System.out.println("----------2--------- = "+a2);
    
    
    //secound higest salary
    
    Optional<Employee> a3 = emps.stream()
    		                    .sorted(Comparator.comparingDouble(Employee::salary))
    		                    .skip(1)
    		                    .findFirst();
    
    System.out.println("----------3--------- = "+a3);
    
    //Count employees per department
    
    Map<String,Long> a4 = emps.stream()
    		                      .collect(Collectors.groupingBy(Employee::dept,Collectors.counting()));
	
    System.out.println("----------3--------- = "+a4);
    
    //Departments where average salary > 60000
    
    List<String> a5 = emps.stream()
    		                  .collect(Collectors.groupingBy(Employee::dept,Collectors.averagingDouble(Employee::salary)))
    		                  .entrySet().stream()
    		                  .filter(x->x.getValue()>60000)
    		                  .map(x->x.getKey())
    		                  .collect(Collectors.toList());
    
    System.out.println("----------4--------- = "+a5);
    }

    public void fun3() {
	
    	List<String> words = List.of("apple", "ant", "ball", "bat", "cat");
    	
    	//Group words by first character
    	Map<Object, List<String>> a1 = words.stream()
    			                           .collect(Collectors.groupingBy(x->x.charAt(0)));
    	
    	System.out.println("----------1--------- = "+a1);
    	
    	String str = "banana";
    	
    	//Count occurrences of each character
    	Map<Object, Long> a2 = str.chars()
    			                 .mapToObj(c->(char)c)
    			                 .collect(Collectors.groupingBy(c->c,Collectors.counting()));
    	
    	System.out.println("----------2--------- = "+a2);
    	
    	String sentence = "java spring java api java spring boot";
    	
    	//Most repeated word in a sentence
    	
    	Entry<String, Long> a3 = Arrays.stream(sentence.split(" "))
    			                      .collect(Collectors.groupingBy(x->x,Collectors.counting()))
    			                      .entrySet().stream()
    			                      .max(Map.Entry.comparingByValue())
    			                      .get();
                                  
    	System.out.println("----------3--------- = "+a3);
    	
    	record Person(String name, int age) {}
    	List<Person> people = List.of(
    	    new Person("A", 25), new Person("B", 32), new Person("C", 41)
    	);

    	Map<String, List<Person>> a4 = people.stream()
    	        .collect(Collectors.groupingBy(p -> {
    	            if (p.age() < 30) return "20–30";
    	            else if (p.age() < 40) return "30–40";
    	            else return "40+";
    	        }));

    	System.out.println("----------4--------- = "+a4);
    	
    	
    }

    public void fun4() {
	
	
    }

    public void fun5() {
	
	
    }

    public void fun6() {
	
	
    }

    public void fun7() {
	
	
    }

}
