package com.springSecurity.SpringSecurityResourceServer1.SecurityExceptionHandler;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler{

	@Override
    public void handle(
            HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException accessDeniedException
    ) throws IOException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = "UNKNOWN";
        
        if(authentication!=null) {
        	    userName = authentication.getName();
        }
        
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");
        
        response.getWriter().write("""
                {
                  "status": 403,
                  "error": "FORBIDDEN",
                  "message": "User '%s' does not have permission to access this resource",
                  "path": "%s"
                }
                """.formatted(userName, request.getRequestURI()));
    }
	
}
