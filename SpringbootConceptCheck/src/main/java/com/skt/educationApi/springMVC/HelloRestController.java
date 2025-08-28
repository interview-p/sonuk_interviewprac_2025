package com.skt.educationApi.springMVC;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

	@GetMapping("/hellods")
    public String hello() {
        return "Hello, Sonu!";
    }
	
	@PostMapping("/register")
	public String register(@ModelAttribute User user) {
	    return "Registered " + user.getName();
	}
}
