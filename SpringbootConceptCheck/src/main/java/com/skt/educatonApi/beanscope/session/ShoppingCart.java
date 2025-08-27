package com.skt.educatonApi.beanscope.session;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;


@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION) // one instance per HTTP session
public class ShoppingCart {

	 private final List<String> items = new ArrayList<>();

	    public void addItem(String item) {
	        items.add(item);
	    }

	    public List<String> getItems() {
	        return items;
	    }

	    public void clear() {
	        items.clear();
	    }
}
