package com.springSecurity.SpringSecurityAuthServer.config;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationSuccessHandler  implements AuthenticationSuccessHandler{

	 @Override
	    public void onAuthenticationSuccess(
	            HttpServletRequest request,
	            HttpServletResponse response,
	            Authentication authentication) {

	        if (authentication.getPrincipal() instanceof UserDetails userDetails) {

	            Set<String> roles = userDetails.getAuthorities().stream()
	                    .map(GrantedAuthority::getAuthority)
	                    .filter(a -> a.startsWith("ROLE_"))
	                    .collect(Collectors.toSet());

	            // store roles inside authentication details
	            ((AbstractAuthenticationToken) authentication)
	                    .setDetails(roles);
	        }
	    }
	 
}
