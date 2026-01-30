package com.springSecurity.SpringSecurityAuthServer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserConfig {

	@Bean
    public UserDetailsService userDetailsService() {

        UserDetails user = User.withUsername("sonu")
                .password("{noop}password")
                .roles("USER")
                .authorities("READ_PROFILE")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password("{noop}admin")
                .roles("ADMIN")
                .authorities("READ_PROFILE", "WRITE_PROFILE")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }
	
}
