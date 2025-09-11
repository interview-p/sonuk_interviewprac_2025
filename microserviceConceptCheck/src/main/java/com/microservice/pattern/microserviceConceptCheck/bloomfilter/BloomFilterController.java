package com.microservice.pattern.microserviceConceptCheck.bloomfilter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/bloomfilter")
public class BloomFilterController {
		
	private final PasswordBloomFilterService bloomService;

    public BloomFilterController(PasswordBloomFilterService bloomService) {
        this.bloomService = bloomService;
    }

    // Add a password hash to Bloom filter
    @GetMapping("/add/{password}")
    public String addPassword(@PathVariable String password) {
        String hash = HashUtil.sha256(password);
        bloomService.addPasswordHash(hash);
        return "Password hash added to Bloom filter: " + hash;
    }

    // Check if password might be leaked
    @GetMapping("/check/{password}")
    public String checkPassword(@PathVariable String password) {
        String hash = HashUtil.sha256(password);
        boolean mightContain = bloomService.mightContain(hash);
        return mightContain ? "Password might be leaked!" : "Password safe";
    }
}

