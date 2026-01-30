package com.springSecurity.SpringSecurityResourceServer1.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

	 @GetMapping("/public")
	    public String publicApi() {
	        return "Public API - No token required";
	    }

	    @GetMapping("/profile")
	    public String profile(Authentication authentication) {
	        return "Hello " + authentication.getName();
	    }

	    @GetMapping("/admin")
	    public String admin() {
	        return "Admin API - Access Granted";
	    }
}
