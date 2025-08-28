package com.skt.educationApi.beanscope.request;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRequestMetadataController {

	private final RequestMetadata requestMetadata;

    public UserRequestMetadataController(RequestMetadata requestMetadata) {
        this.requestMetadata = requestMetadata;
    }

    @GetMapping("/request-metadata")
    public Map<String, Object> getMetadata() {
        return Map.of(
                "ipAddress", requestMetadata.getIpAddress(),
                "userAgent", requestMetadata.getUserAgent(),
                "method", requestMetadata.getMethod(),
                "uri", requestMetadata.getUri(),
                "headers", requestMetadata.getHeaders()
        );
    }
}
