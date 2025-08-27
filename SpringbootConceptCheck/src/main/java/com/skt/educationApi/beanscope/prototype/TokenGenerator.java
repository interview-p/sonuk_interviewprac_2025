package com.skt.educationApi.beanscope.prototype;

import java.time.Instant;
import java.util.UUID;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")  // new instance every time
public class TokenGenerator {

	private final String token = UUID.randomUUID().toString();
    private final Instant createdAt = Instant.now();

    public String getToken() {
        return token;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
