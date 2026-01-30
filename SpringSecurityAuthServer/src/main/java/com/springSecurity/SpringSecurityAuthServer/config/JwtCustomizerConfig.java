package com.springSecurity.SpringSecurityAuthServer.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;


@Configuration
public class JwtCustomizerConfig {

	@Bean
    public OAuth2TokenCustomizer<JwtEncodingContext> jwtCustomizer() {

        return context -> {

        	 if (!OAuth2TokenType.ACCESS_TOKEN.equals(context.getTokenType())) {
                 return;
             }

             Authentication authentication = context.getPrincipal();

             Set<String> roles = new HashSet<>();
             Set<String> authorities = new HashSet<>();
             roles.add("sonu");
             roles.add("kumar");

             // 1️⃣ OAuth2 authorities (scopes / permissions)
             authentication.getAuthorities().forEach(a ->
                     authorities.add(a.getAuthority())
             );

             // 2️⃣ Extract roles from UserDetails
             Object principal = authentication.getPrincipal();

             if (principal instanceof UserDetails userDetails) {
                 userDetails.getAuthorities().forEach(a -> {
                     if (a.getAuthority().startsWith("ROLE_")) {
                         roles.add(a.getAuthority());
                     }
                 });
             }

             context.getClaims().claim("roles", roles);
             context.getClaims().claim("authorities", authorities);
        };
    }
}
