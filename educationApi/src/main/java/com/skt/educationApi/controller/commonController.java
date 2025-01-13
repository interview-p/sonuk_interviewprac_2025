package com.skt.educationApi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/education")
public class commonController {

	@GetMapping("/admin")
	public ResponseEntity<String> getAdminDetails() {
			
		
		// when we add spring security dependency in pom spring automatically configure userDetail class which
		// is store in authentication object from which we can get userdetail and other
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		 if (authentication != null) {
	            Object principal = authentication.getPrincipal();
	            
	            // Check if the principal is an instance of UserDetails (default in Spring Security)
	            if (principal instanceof UserDetails) {
	            	return ResponseEntity.ok("Hello Admin"+ ((UserDetails) principal).getUsername());
	            } else {
	                // If it's not an instance of UserDetails (e.g., a string username), return it
	            	return ResponseEntity.ok("Hello Admin userdetail not instance of principal");
	            }
	}
		 return ResponseEntity.ok("Hello Admin");
}
	
	@GetMapping("/admin1")
	public ResponseEntity<String> getAdminDetails1() {
			
		 return ResponseEntity.ok("Hello Admin1");
		
	}		
}

