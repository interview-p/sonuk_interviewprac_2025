package com.skt.educationApi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/login").permitAll() // Permit unauthenticated access to /public/*
            .anyRequest().authenticated()  // Require authentication for other endpoints
            .and()
            .formLogin()
              .loginPage("/login") // Specify the custom login page URL
              .loginProcessingUrl("/login") // URL to process the login form
              .defaultSuccessUrl("/home", true) // Redirect after successful login
              .failureUrl("/login?error=true") // Redirect to login page on failure
          .and()
          .logout()
              .logoutUrl("/logout") // Specify the logout URL
              .logoutSuccessUrl("/login?logout=true"); 

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
            User.withUsername("user")
                .password(passwordEncoder().encode("passwordlo"))
                .roles("USER")
                .build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}