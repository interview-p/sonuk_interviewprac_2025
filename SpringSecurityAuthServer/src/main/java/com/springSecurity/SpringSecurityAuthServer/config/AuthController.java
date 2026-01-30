package com.springSecurity.SpringSecurityAuthServer.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

	    @GetMapping("/authorized")
	    public String authorized() {
	        return "Authorization successful! Code = ";
	    }
	 
}
