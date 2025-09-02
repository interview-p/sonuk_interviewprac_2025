package com.skt.educationApi.springMVC;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;

@RestController
public class HelloRestController {

	/*
	 @SessionAttributes (plural) = class-level annotation, tells Spring to promote specific model attributes into session.
     @SessionAttribute (singular, method param) = directly fetch an attribute from session (without model binding).
	 */
	
	
	    @GetMapping("/start2")
	    public String start(HttpSession session) {
	        Student usr = new Student();
	        session.setAttribute("user1", usr);
	        return "name set";
	    }
	 
	
	    @GetMapping("/saveStep2")
	    public String saveStep1(HttpSession session) {
	        Student user = (Student) session.getAttribute("user1");
	        if (user == null) {
	            return "No user found in session!";
	        }
	        user.setName("sonu");
	        return "name set in session";
	    }
	  
	    @GetMapping("/profile2")
	    public String showProfile(@SessionAttribute("user1") Student user) {
	        return "user name fetch from session = " + user.getName();
	    }
}
