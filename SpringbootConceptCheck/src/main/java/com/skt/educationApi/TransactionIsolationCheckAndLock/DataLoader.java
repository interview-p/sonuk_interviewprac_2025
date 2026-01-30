package com.skt.educationApi.TransactionIsolationCheckAndLock;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {


    @Bean
    CommandLineRunner load(AccountRepository repo) {
        return args -> {
            repo.save(new Account(1L, 100 , "NEW"));
        };
    }
}
