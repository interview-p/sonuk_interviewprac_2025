package com.microservice6.microservice6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/microservice6")
public class controller {

	 @Value("${spring.application.name}")
	 private String appName;
	 
	 
	 @Autowired
	 private Environment env;
	 
	@GetMapping("/check")
	public String check_test() {
	     return "Hai this is microservice-4";
	 }
	
	@GetMapping("/sdcheck")
	public String check_test1() {
		 String port = env.getProperty("local.server.port"); // actual port assigned
	     return "Response from " + appName + " running on port " + port;
	 }
}
