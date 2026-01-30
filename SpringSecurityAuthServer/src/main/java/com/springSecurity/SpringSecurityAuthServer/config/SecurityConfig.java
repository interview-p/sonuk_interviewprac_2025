package com.springSecurity.SpringSecurityAuthServer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.authorization.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

@Configuration
public class SecurityConfig {

	private final CustomAuthenticationSuccessHandler successHandler;

    public SecurityConfig(
            CustomAuthenticationSuccessHandler successHandler) {
        this.successHandler = successHandler;
    }
    
	@Order(1)
	@Bean
    public SecurityFilterChain authServerSecurity(HttpSecurity http) throws Exception {

		 OAuth2AuthorizationServerConfigurer authorizationServerConfigurer =
	                new OAuth2AuthorizationServerConfigurer();

	        http
	            .securityMatcher(authorizationServerConfigurer.getEndpointsMatcher())
	            .authorizeHttpRequests(authorize -> authorize.requestMatchers("/").denyAll()
	            		.anyRequest().authenticated()
	            		)
	            .csrf(csrf -> csrf.ignoringRequestMatchers(
	                    authorizationServerConfigurer.getEndpointsMatcher()
	            ))
	            .exceptionHandling(e->e.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login")))
	            .apply(authorizationServerConfigurer);
	        
	        authorizationServerConfigurer.oidc(Customizer.withDefaults());

        return http.build();
    }
	
	@Order(2)
	@Bean
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .authorizeHttpRequests(authorize -> authorize
	        		.requestMatchers("/error").permitAll()
	            .anyRequest().authenticated()
	        )
	        .formLogin(Customizer.withDefaults());
	        //.formLogin(form-> form.successHandler(successHandler));

	    return http.build();
	}
}


