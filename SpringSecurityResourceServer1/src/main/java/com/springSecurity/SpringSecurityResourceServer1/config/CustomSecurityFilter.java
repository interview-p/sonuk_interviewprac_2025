package com.springSecurity.SpringSecurityResourceServer1.config;

import java.io.IOException;

import org.springframework.boot.security.oauth2.server.resource.autoconfigure.OAuth2ResourceServerProperties.Jwt;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomSecurityFilter extends OncePerRequestFilter{

	@Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof JwtAuthenticationToken jwtAuth) {

            org.springframework.security.oauth2.jwt.Jwt jwt = jwtAuth.getToken();

            // Example: custom claim validation
            String clientType = jwt.getClaimAsString("aud");

            if (!"[web-client]".equals(clientType)) {
                throw new AccessDeniedException("Invalid client type");
            }
        }

        filterChain.doFilter(request, response);
    }
	
	/*
	  when we add oauth2ResourceServer in securityconfig spring automatically add
	  BearerTokenAuthenticationFilter , if we want to add our custom authentication
	  filter create filter than pass into securityConfig and  explicitally add customfilter
	  after BearerTokenAutheticationFilter
	  
	  this filter is create to check controller come into this class or not 
	  or just check client_id we specify if match we able to access api  or throw invalid client error
	 */
}
