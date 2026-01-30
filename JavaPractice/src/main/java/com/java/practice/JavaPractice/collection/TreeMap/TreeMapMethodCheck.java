package com.java.practice.JavaPractice.collection.TreeMap;

import java.util.ArrayDeque;
import java.util.TreeMap;

public class TreeMapMethodCheck {
	
	 public static void main(String[] args) {
		 
		 TreeMap<Integer, String> map = new TreeMap<>();

		 map.put(10, "A");
		 map.put(20, "B");
		 map.put(30, "C");
		 map.put(40, "D");
		 map.put(50, "E");
		 
		 String a = map.get(20); // "B"
		 System.out.println("a = "+a);
		 System.out.println("contain 40 = "+map.containsKey(40));
		 System.out.println("contain value C = "+map.containsValue("G"));
		 
		 System.out.println("return smallest key = "+map.firstKey());
		 /*
		   user case:-
		   ✔ Oldest timestamp ✔ Lowest price in order book ✔ Earliest scheduled task
		  */
		 System.out.println("return largest key  = "+map.lastKey());
		 /*
		  ✔ Latest event ✔ Highest score ✔ Maximum allowed threshold
		  */
		 System.out.println("Greatest key strictly less than given key = "+map.lowerKey(30));
		 /*
		  ✔ Find previous version ✔ Previous checkpoint ✔ Last known state before failure
		  */
		 System.out.println("Greatest key ≤ given key = "+map.floorKey(35));
		 /*
		  ✔ Nearest historical data ✔ Pricing tiers (<= value) ✔ Cache fallback logic
		  */
		 System.out.println("Smallest key ≥ given key = "+map.ceilingKey(35));
		 /*
		  ✔ Next scheduled job ✔ Nearest future event ✔ SLA deadline calculation
		  */
		 
		 System.out.println("Smallest key strictly greater than given key = "+map.higherKey(30));
		 /*
		  ✔ Next retry time ✔ Next leaderboard rank ✔ Pagination cursors
		  */
		 System.out.println("Smallest key ≥ given key = "+map.ceilingKey(35));
		 
		 
		 ArrayDeque<Character> dq = new ArrayDeque<>();
		 
		 
		 
		
	 }
}
