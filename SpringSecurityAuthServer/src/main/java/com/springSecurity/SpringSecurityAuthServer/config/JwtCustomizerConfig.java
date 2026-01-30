package com.springSecurity.SpringSecurityAuthServer.config;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;


@Configuration
public class JwtCustomizerConfig {

	@Bean
    public OAuth2TokenCustomizer<JwtEncodingContext> jwtCustomizer() {

        return context -> {

            if (OAuth2TokenType.ACCESS_TOKEN.equals(context.getTokenType())) {

                Authentication authentication = context.getPrincipal();

                if (authentication.getPrincipal() instanceof UserDetails user) {

                    Set<String> authorities = user.getAuthorities()
                            .stream()
                            .map(GrantedAuthority::getAuthority)
                            .collect(Collectors.toSet());

                    context.getClaims().claim("authorities", authorities);
                }
            }
        };
    }
}
