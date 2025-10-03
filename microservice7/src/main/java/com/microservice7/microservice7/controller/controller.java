package com.microservice7.microservice7.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/microservice7")
public class controller {

	@GetMapping("/check")
	public String check_test() {
	      return "Hai this is microservice-7";
	 }
}
