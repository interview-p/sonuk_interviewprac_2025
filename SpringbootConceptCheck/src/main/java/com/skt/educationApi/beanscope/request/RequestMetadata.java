package com.skt.educationApi.beanscope.request;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import jakarta.servlet.http.HttpServletRequest;

@Component
@RequestScope
public class RequestMetadata {


    private final String ipAddress;
    private final String userAgent;
    private final String method;
    private final String uri;
    private final Map<String, String> headers = new HashMap<>();

    public RequestMetadata(HttpServletRequest request) {
        // Capture IP
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null) {
            ip = request.getRemoteAddr();
        }
        this.ipAddress = ip;

        // Capture User-Agent
        this.userAgent = request.getHeader("User-Agent");

        // Capture method + URI
        this.method = request.getMethod();
        this.uri = request.getRequestURI();

        // Capture all headers
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.put(headerName, request.getHeader(headerName));
        }
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getMethod() {
        return method;
    }

    public String getUri() {
        return uri;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
    
}
