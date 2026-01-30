package com.springSecurity.SpringSecurityResourceServer1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.oauth2.server.resource.web.authentication.BearerTokenAuthenticationFilter;
import org.springframework.security.web.SecurityFilterChain;

import com.springSecurity.SpringSecurityResourceServer1.SecurityExceptionHandler.CustomAccessDeniedHandler;
import com.springSecurity.SpringSecurityResourceServer1.SecurityExceptionHandler.CustomAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity 
public class SecurityConfig {

	 private final CustomAuthenticationEntryPoint authenticationEntryPoint;
	    private final CustomAccessDeniedHandler accessDeniedHandler;

	    public SecurityConfig(
	            CustomAuthenticationEntryPoint authenticationEntryPoint,
	            CustomAccessDeniedHandler accessDeniedHandler
	    ) {
	        this.authenticationEntryPoint = authenticationEntryPoint;
	        this.accessDeniedHandler = accessDeniedHandler;
	    }
	    
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http,CustomSecurityFilter customSecurityFilter) throws Exception {

	        http
	            .csrf(csrf -> csrf.disable())
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers("/public").permitAll()
	                .requestMatchers("/secure/admin").hasRole("ADMIN")
	                .requestMatchers("/profile").hasAuthority("SCOPE_profile")
	                .anyRequest().authenticated()
	            )
	            .exceptionHandling(ex-> ex.authenticationEntryPoint(authenticationEntryPoint)
	            		                      .accessDeniedHandler(accessDeniedHandler))
	            .oauth2ResourceServer(oauth2 ->
	                oauth2.jwt(jwt ->
	                    jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())
	                )
	            )
	            .addFilterAfter(customSecurityFilter,
                        BearerTokenAuthenticationFilter.class);

	        return http.build();
	        
	        /*
	      adding this line .oauth2ResourceServer(oauth2 ->) 
	      That automatically adds these internal filters:          
	                    
BearerTokenAuthenticationFilter
  → JwtDecoder
  → JwtAuthenticationProvider
  → JwtAuthenticationConverter
  → SecurityContextHolder
  
  ✔ JWT is already validated (signature, exp, nbf, iss, aud)
✔ Authentication is already in SecurityContextHolder

👉 Your custom filter MUST run AFTER JWT authentication
	         */
	    }

	    @Bean
	    public JwtAuthenticationConverter jwtAuthenticationConverter() {

	        JwtGrantedAuthoritiesConverter authoritiesConverter =
	                new JwtGrantedAuthoritiesConverter();

	        // For scopes → SCOPE_xxx
	        authoritiesConverter.setAuthorityPrefix("SCOPE_");
	        authoritiesConverter.setAuthoritiesClaimName("scope");

	        authoritiesConverter.setAuthorityPrefix("ROLE_");
	        authoritiesConverter.setAuthoritiesClaimName("roles");
	        
	        JwtAuthenticationConverter converter =
	                new JwtAuthenticationConverter();

	        converter.setJwtGrantedAuthoritiesConverter(authoritiesConverter);

	        return converter;
	    }
	    
}
