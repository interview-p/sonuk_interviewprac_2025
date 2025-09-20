package com.microservices.microservices_project_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.microservices_project_1.memoryLeak.EdenSpaceExample;
import com.microservices.microservices_project_1.memoryLeak.MemoryLeakExample;


@RestController
@RequestMapping("/bloomfilter")
public class Controller {

	@Value("${myapp.secret.code}")
	private String secretCode;
	
	@Autowired
	private MemoryLeakExample leakobj;
	
	@Autowired
	EdenSpaceExample edenobj;
	
	 @GetMapping("/hello")
	 public String addPassword() {
	        return "hello namaskar ap kaise ho secret code "+secretCode+" hai";
	 }
	 
	 @GetMapping("/leakcheck")
	 public String leakcheck() throws InterruptedException {
	  
		 leakobj.check();
		 return "leak check completed";
	 }
	 
	 @GetMapping("/edenleakcheck")
	 public String edenleakcheck() throws InterruptedException {
	  
		 edenobj.check();
		 return "leak check completed";
	 }
}
