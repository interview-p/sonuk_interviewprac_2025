package com.microservice.pattern.microserviceConceptCheck.bloomfilter;

import org.springframework.stereotype.Service;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import java.nio.charset.StandardCharsets;

@Service
public class PasswordBloomFilterService {

	private final BloomFilter<CharSequence> bloomFilter;

    public PasswordBloomFilterService() {
        // expected 5000 insertions, 1% false positive probability
        bloomFilter = BloomFilter.create(
                Funnels.stringFunnel(StandardCharsets.UTF_8),
                10,
                0.1
        );
    }
    
    /*
     note - if we set 5000,0.01(1%) mean we can add 5000 element and can manage 1 false result in 100 element
     first parameter(no of element we want to store)  
     secound parameter(probabality value at which level we can manage false-positive predection_
           
     to test false-positive result -> set element 10 and make heigher probablity value like 0.1(10%)
     once all block of byte array filled early and we use 0.1 means less k value(no of hash function)
     value k = 1 or 2 mean we fill two block for a element so there is high chance another
     random value get same index value and bloomfilter return password present
                                      
     so higher element value and less probability value higher chance for consistance value
              */

    public void addPasswordHash(String hash) {
        bloomFilter.put(hash);
    }

    public boolean mightContain(String hash) {
        return bloomFilter.mightContain(hash);
    }
    
}
