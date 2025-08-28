package com.skt.educationApi.beanscope.session;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;


@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION,  proxyMode = ScopedProxyMode.TARGET_CLASS) // one instance per HTTP session
public class ShoppingCart {

	// proxyMode = ScopedProxyMode.TARGET_CLASS - we need to  provide the proxy mode ->
	/*
	 * when spring container start spring create cartService object and try to inject shoppingCart
	 * service object but spring not create object for that becoz it is session scope and get error
	 * when we apply proxy mode spring create proxy for that class
	 * 
	 * when application start there is no session exist in web container mean no object found in session
	 * but when http request come spring create session in web container and when spring inject 
	 * that bean inside orderservice class proxy create real object and inject into reference on that
	 * class and store in session
	 */
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
