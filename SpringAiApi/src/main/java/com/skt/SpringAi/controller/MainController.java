package com.skt.SpringAi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/login")
    public String loginPage() {
        return "login";  // Return the login.html page
    }

    @GetMapping("/home")
    public String home() {
        return "home";  // Return the home page after login
    }
}
