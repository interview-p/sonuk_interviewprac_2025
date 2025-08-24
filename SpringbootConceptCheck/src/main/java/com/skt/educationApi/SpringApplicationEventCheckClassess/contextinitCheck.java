package com.skt.educationApi.SpringApplicationEventCheckClassess;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class contextinitCheck {

	@Value("${app.custom.value}")
	private String customValue;
	
	// it won't print the value 
	//in Spring, @Value injection happens after the bean object is created but before it is fully initialized and ready for use.
	public contextinitCheck() {
		System.out.println("inside contextInitCheck constructor customvalue properties value = "+customValue);
	}
	
	 public void printValue() {
	        System.out.println("Injected value: " + customValue);
	    }
}
