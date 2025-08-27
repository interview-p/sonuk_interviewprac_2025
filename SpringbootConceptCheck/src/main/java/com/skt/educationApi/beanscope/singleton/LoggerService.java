package com.skt.educationApi.beanscope.singleton;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class LoggerService {

	
	 public void log(String message) {
	        System.out.println("[LOG] " + message);
	    }
}
