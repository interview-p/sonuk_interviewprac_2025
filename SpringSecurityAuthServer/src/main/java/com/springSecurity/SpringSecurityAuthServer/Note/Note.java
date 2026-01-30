package com.springSecurity.SpringSecurityAuthServer.Note;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.authorization.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

public class Note {

/*
to configure auth server we have to do some configuration 
first we have to create some client than user and if we want to customize token we can do using OAuth2TokenCustomizer

create client - create one class and create bean of RegisteredClient and registered multiple client
    into InMemoryRegisteredClientRepository spring automatically configure it with.
    
create user - create class userconfig where create bean of UserDetailsService(this class is actually
 spring understand where user username password saved)
 and than registered into InMemoryRegisteredClientRepository
 
customize token - create class jwtCustomizer where create bean of OAuth2TokenCustomizer where we can
   cutomize what we want in json web token. like we we want role we can add it 
   	
	this is important class for auth2.0 authentication:-
	
	here we use two @order which us required for auth2.0 authentication
	
	@Order(1)	Protects OAuth2 / OIDC authorization server endpoints
    @Order(2)	Protects normal application endpoints like /login, /error, UI 
    
    Spring Security will try filter chains in order, and the first matching chain wins.
    
    Why TWO SecurityFilterChains are REQUIRED
    Spring Authorization Server adds many endpoints automatically, such as:
    /oauth2/authorize ,/oauth2/token, /oauth2/jwks,/oauth2/introspect,/oauth2/revoke,/.well-known/openid-configuration
    /userinfo (OIDC)
     * These endpoints need very special security rules, different from normal login pages.
      
      @Order(1) — Authorization Server Filter Chain
      This chain is applied ONLY to: -> authorizationServerConfigurer.getEndpointsMatcher()
      Any request hitting above  endpoints will NEVER go to Order(2)
      All OAuth endpoints → require authentication
      
      why we use these:->
      .apply(authorizationServerConfigurer);
      .authorizationServerConfigurer.oidc(Customizer.withDefaults());
      
      Registers OAuth2 filters,Registers OIDC filters
      these include OAuth2AuthorizationEndpointFilter,OAuth2TokenEndpointFilter,OidcUserInfoEndpointFilter
      JWKSetEndpointFilter
      Without this → your auth server DOES NOT WORK.
      
      
      @Order(2) — Default Application Security
      This is for everything else, including:/login , /error, Any UI or normal API
      if any url come with these secound securityFilter work
      
      .formLogin(Customizer.withDefaults());
      This enables:
      /login page
      Username/password authentication
      Session creation
      This is the login page used by Order(1) when redirecting unauthenticated users.
      
      
      FULL REQUEST FLOW (MOST IMPORTANT)
      Authorization Code Flow
      Step 1: Client hits
      GET /oauth2/authorize?client_id=...
      ➡ Matches Order(1)
      ➡ User NOT authenticated
      ➡ Redirect to /login
      explain:-> when we hit this url user is not authenticate because as of now we have not mentation
      any user what happen anonymousFilter will create Authentication object = null
      this throw AuthenticationException(401) .
      ExceptionHandler accept this exception and redirect to /login url due to this line
      .exceptionHandling(e->e.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login")))
      
      when user redirect to /login secound order intercept this /login url because
      we use .formLogin(Customizer.withDefaults()); it enable /login url
      once control come to /login page a new form is open 
      we put userName and password and new filter trigger UserNamePasswordAuthenticationFilter
      once we enter spring check into InmemoryRegistrationRepository it found
      it return authorization_code in return url
      
      once we get auth_code we use POST /oauth2/token with auth_code it generate access_toke
      oidc_token and refresh token
      
      
 
 # if we not use  .exceptionHandling(e->e.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login") what happen
 
 👉 then unauthenticated requests to OAuth2 endpoints will NOT be redirected to /login
👉 instead, Spring Security will return 401 Unauthorized (or sometimes 403)
👉 and Authorization Code Flow will break for browser-based login

process of testing :- 
from browser:-
1> call http://localhost:9000/oauth2/
http://localhost:9000/oauth2/authorize?response_type=code&client_id=web-client2&scope=openid%20profile&redirect_uri=http://localhost:9000/authorized
2> ask username password enter detail in return auth_code generate
3> call http://localhost:9000/oauth2/token with this code 
4> but using browser it is not possiable

from postman 

put all url in postman . internally postman call /authorize url generate auth_code internally use this code
and call /token url





	 */
}
