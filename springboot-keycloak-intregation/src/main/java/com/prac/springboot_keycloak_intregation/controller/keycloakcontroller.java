package com.prac.springboot_keycloak_intregation.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class keycloakcontroller {

	@GetMapping("/admin")
	public ResponseEntity<String> getAdminDetails() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
 
		 Jwt jwt = (Jwt) authentication.getPrincipal();
		//System.out.println(jwt.getClaimAsString("sub"));
		System.out.println( jwt.getClaims());
		
		return ResponseEntity.ok("Hello Admin");
	}

	@GetMapping("/user")
	public ResponseEntity<String> getUserDetails() {
		return ResponseEntity.ok("Hello User");
	}
	
}
