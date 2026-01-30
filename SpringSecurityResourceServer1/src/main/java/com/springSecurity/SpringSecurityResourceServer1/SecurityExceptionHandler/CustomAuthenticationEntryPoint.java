package com.springSecurity.SpringSecurityResourceServer1.SecurityExceptionHandler;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint{

	 @Override
	    public void commence(
	            HttpServletRequest request,
	            HttpServletResponse response,
	            AuthenticationException authException
	    ) throws IOException {

	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	        response.setContentType("application/json");

	        response.getWriter().write("""
	        {
	          "status": 401,
	          "error": "UNAUTHORIZED",
	          "message": "Access token is missing or invalid",
	          "path": "%s"
	        }
	        """.formatted(request.getRequestURI()));
	    }
}
