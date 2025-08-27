package com.skt.educationApi.beanscope.prototype;

import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

	private final ObjectProvider<TokenGenerator> tokenProvider;
    private final Map<String, TokenGenerator> activeSessions = new ConcurrentHashMap<>();

    private static final long TOKEN_EXPIRY_SECONDS = 60; // 5 minutes

    public AuthService(ObjectProvider<TokenGenerator> tokenProvider) {
        this.tokenProvider = tokenProvider;
    }
    
    public String login2(String username) {
        TokenGenerator tokenGen = createTokenGenerator(); // overridden by Spring
        activeSessions.put(username, tokenGen);
        return "User " + username + " logged in with token: " + tokenGen.getToken();
    }
    
    @Lookup
    protected TokenGenerator createTokenGenerator() {
        // Spring overrides this method at runtime
        return null;
    }

    // Login -> create token
    public String login(String username) {
        TokenGenerator tokenGen = tokenProvider.getObject(); // new instance
        activeSessions.put(username, tokenGen);
        return "User " + username + " logged in with token: " + tokenGen.getToken();
    }

    // Get token -> check expiry
    public String getToken(String username) {
        TokenGenerator tokenGen = activeSessions.get(username);
        if (tokenGen == null) {
            return "No active session!";
        }

        if (isExpired(tokenGen)) {
            activeSessions.remove(username);
            return "Session expired for user: " + username;
        }

        return tokenGen.getToken();
    }

    // Logout -> remove token
    public String logout(String username) {
        TokenGenerator removed = activeSessions.remove(username);
        return removed != null ? "User " + username + " logged out!" : "No active session!";
    }

    // Auto-cleanup expired tokens every minute
    //@Scheduled(fixedRate = 60000) // runs every 60s
    public void cleanupExpiredTokens() {
        Instant now = Instant.now();
        activeSessions.entrySet().removeIf(entry -> 
            	
            Duration.between(entry.getValue().getCreatedAt(), now).getSeconds() > TOKEN_EXPIRY_SECONDS
        );
    }

    private boolean isExpired(TokenGenerator tokenGen) {
        return Duration.between(tokenGen.getCreatedAt(), Instant.now()).getSeconds() > TOKEN_EXPIRY_SECONDS;
    }
}
