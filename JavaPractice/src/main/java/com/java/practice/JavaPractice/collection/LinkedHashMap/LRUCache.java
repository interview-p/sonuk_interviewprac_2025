package com.java.practice.JavaPractice.collection.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer, String>{

	 private final int capacity;

	    public LRUCache(int capacity) {
	        // initialCapacity, loadFactor, accessOrder = true
	        super(capacity, 0.75f, true);
	        this.capacity = capacity;
	    }

	    @Override
	    protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
	        return size() > capacity;
	    }

	    public static void main(String[] args) {
	        LRUCache cache = new LRUCache(3);

	        cache.put(1, "A");
	        cache.put(2, "B");
	        cache.put(3, "C");

	        System.out.println(cache); // {1=A, 2=B, 3=C}

	        cache.get(1);              // access key 1 → becomes most recently used
	        cache.put(4, "D");         // removes eldest (key=2)

	        System.out.println(cache); // {3=C, 1=A, 4=D}
	    }
	    
	    /*
	      here removeEldestEntry is used to remove element based on condition 
	      here we pass 3 as capacity mean we can keep only three data else delete
	      
	      here we use get(1) now A is recent used so order became 
	      B-C-A
	      not put D mean order became A-B-C-D but as per removeEldestEntry keep only 3 data 
	      so least use or element at first position need to remove
	     */

}
