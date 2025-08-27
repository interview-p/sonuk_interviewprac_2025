package com.skt.educationApi.beanscope.prototype;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

	    private final AuthService authService;

	    public AuthController(AuthService authService) {
	        this.authService = authService;
	    }

	    @PostMapping("/login/{username}")
	    public String login(@PathVariable String username) {
	        return authService.login2(username);
	    }

	    @GetMapping("/token/{username}")
	    public String getToken(@PathVariable String username) {
	        return authService.getToken(username);
	    }

	    @PostMapping("/logout/{username}")
	    public String logout(@PathVariable String username) {
	        return authService.logout(username);
	    }
	    
}
