package com.springSecurity.SpringSecurityAuthServer.config;

import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;

@Configuration
public class ClientConfig {

	 @Bean
	    public RegisteredClientRepository registeredClientRepository() {

	        RegisteredClient webClient1 =
	        		 RegisteredClient.withId(UUID.randomUUID().toString())
	                    .clientId("web-client")
	                    .clientSecret("{noop}web-secret")
	                    .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
	                    .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
	                    .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
	                    //.redirectUri("http://localhost:8080/login/oauth2/code/web-client")
	                    .redirectUri("http://localhost:9000/authorized")
	                    .scope(OidcScopes.OPENID)
	                    .scope("profile")
	                    .scope("orders.read")
	                    .clientSettings(ClientSettings.builder()
	                            .requireProofKey(false) // 👈 explicitly disable PKCE
	                            .build())
	                    .build();
	        
	        RegisteredClient webClient2 =
	        		 RegisteredClient.withId(UUID.randomUUID().toString())
	                    .clientId("web-client2")
	                    .clientSecret("{noop}web-secret2")
	                    .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
	                    .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
	                    .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
	                    //.redirectUri("http://localhost:8080/login/oauth2/code/web-client")
	                    .redirectUri("http://localhost:9000/authorized")
	                    .scope(OidcScopes.OPENID)
	                    .scope("profile")
	                    .scope("orders.read")
	                    .clientSettings(ClientSettings.builder()
	                            .requireProofKey(false) // 👈 explicitly disable PKCE
	                            .build())
	                    .build();

	        RegisteredClient serviceClient =
	                RegisteredClient.withId(UUID.randomUUID().toString())
	                        .clientId("service-client")
	                        .clientSecret("{noop}service-secret")
	                        .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
	                        .scope("orders.read")
	                        .scope("orders.write")
	                        .build();

	        return new InMemoryRegisteredClientRepository(webClient1, webClient2,serviceClient);
	    }
	 
}
