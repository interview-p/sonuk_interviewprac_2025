package com.java.practice.JavaPractice.collection.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

public class EventHistory extends LinkedHashMap<Long, String>{

	private static final int MAX_EVENTS = 5;

    @Override
    protected boolean removeEldestEntry(Map.Entry<Long, String> eldest) {
        return size() > MAX_EVENTS;
    }

    public static void main(String[] args) {
        EventHistory history = new EventHistory();

        history.put(1L, "LOGIN");
        history.put(2L, "VIEW_PAGE");
        history.put(3L, "ADD_TO_CART");
        history.put(4L, "LOGOUT");
        history.put(5L, "LOGIN_AGAIN");
        history.put(6L, "PAYMENT");

        System.out.println(history);
        
        //Oldest event is removed automatically.
    }

}
