package com.springSecurity.SpringSecurityResourceServer1.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure")
public class SecureController {

	@PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String adminOnly() {
        return "Admin Method Authorized";
    }

    @PreAuthorize("hasAuthority('SCOPE_profile')")
    @GetMapping("/profile")
    public String profileScope() {
        return "Profile Scope Authorized";
    }
    
}
