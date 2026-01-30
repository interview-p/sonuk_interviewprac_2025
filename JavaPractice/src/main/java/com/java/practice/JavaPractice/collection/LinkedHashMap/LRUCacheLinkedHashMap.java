package com.java.practice.JavaPractice.collection.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLinkedHashMap {

	public static void main(String[] args) {
		
		
		Map<String, Integer> cache = new LinkedHashMap<>(3, 0.75f, true);
		// true - mean it maintain LRU order(last recent order
		// false - mean it maintain FIFO order(first in fast out)
		cache.put("A", 1);cache.put("B", 2);cache.put("C", 3);cache.put("D", 4);
		
	        System.out.println(cache); // {1=A, 2=B, 3=C}

	        cache.get("A");              // access key 1 → becomes most recently used
	        cache.put("E",4);         // removes eldest (key=2)

	        System.out.println(cache); // {3=C, 1=A, 4=D}
	        
		    
	        /*
	         here as we know linkedHashMap maintain one doublyLinkedList which 
	         insertion order . and if we use any put or get operation that key be 
	         recent used and come at last(last mean recent used)
	         
	         so  before get it is A,B,C,D
	         after get it is B,C,D,A,E
	     
	         */
	        
	}
	
}
