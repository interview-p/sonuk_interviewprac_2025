package com.microservice4.microservice4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/microservice4")
public class controller {

	@GetMapping("/check")
	public String check_test() {
	      return "Hai this is microservice-4";
	 }
	@GetMapping("/circuit/api/data")
	public String check_test1() {
	      return "Hai this is microservice-4";
	 }
}
