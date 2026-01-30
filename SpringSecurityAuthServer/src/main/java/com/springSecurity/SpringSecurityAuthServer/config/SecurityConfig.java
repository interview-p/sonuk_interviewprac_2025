package com.springSecurity.SpringSecurityAuthServer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.authorization.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
    public SecurityFilterChain authServerSecurity(HttpSecurity http) throws Exception {

		 OAuth2AuthorizationServerConfigurer authorizationServerConfigurer =
	                new OAuth2AuthorizationServerConfigurer();

	        http
	            .securityMatcher(authorizationServerConfigurer.getEndpointsMatcher())
	            .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
	            .csrf(csrf -> csrf.ignoringRequestMatchers(
	                    authorizationServerConfigurer.getEndpointsMatcher()
	            ))
	            .apply(authorizationServerConfigurer);
	        
	        authorizationServerConfigurer.oidc(Customizer.withDefaults());

        return http.build();
    }
	
	@Bean
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .authorizeHttpRequests(authorize -> authorize
	            .anyRequest().authenticated()
	        )
	        .formLogin(Customizer.withDefaults());

	    return http.build();
	}
}


