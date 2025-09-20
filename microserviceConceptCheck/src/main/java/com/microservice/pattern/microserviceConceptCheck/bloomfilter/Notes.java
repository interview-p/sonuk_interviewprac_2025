package com.microservice.pattern.microserviceConceptCheck.bloomfilter;

public class Notes {

	/*
	Bloom Filter with Password Hashes — Key Points
	
	Purpose of Bloom Filter
	Probabilistic data structure to check if an element might exist.
	Can return false positives (says “maybe present”), but never false negatives if inputs are consistent.
	Saves memory — stores bits, not the actual data.
	
	What you pass to Bloom Filter
	
	You can pass raw passwords or password hashes (SHA-256, SHA-1, etc.).
	The Bloom filter will treat the input as bytes and internally hash it again to compute indexes.
	what we pass as input bloomfilter hash it using 128-bit and split that number half and assign
	it back to h1 and h2(called double hashing)
	Internal hash functions (h1, h2)
	Bloom filter uses double hashing to generate k indexes:
	  index_i = (h1 + i*h2) % m
	  
	h1 and h2 are derived from an internal 128-bit hash (e.g., Murmur3_128).
    This allows k bit positions to be set per element, without computing k separate hashes.
    
    Number of hash functions (k)

    k is the number of bits each element sets in the bit array.
    Determined automatically using formula:
    k = (m / n) * ln2
    More hash functions → fewer false positives (up to an optimal point)(it depend on probability value we pass in function)
    
    Too many → array fills too fast → false positives increase.
    
    Bit array (m)

    Size of Bloom filter in bits.
    Larger m → lower false positive probability.
    Formula depends on expected insertions n and desired false positive rate p:
    m = -(n * ln(p)) / (ln2)^2

Effect of passing different external hash algorithms

All passwords must be hashed consistently (e.g., all SHA-256).
Using different hashes (SHA-512, SHA-1, etc.) → Bloom filter sees different byte sequences → indexes differ → may cause false negatives.
Consistency is critical; otherwise, the filter becomes unreliable.
Set bits vs k
k = number of bits attempted to set per element (fixed).
Bit count = total number of 1s in the array → grows over multiple inserts; overlaps reduce new bits added.

How membership check works (mightContain)

Compute k indexes for input.
If all k bits are 1 → “maybe present” (could be false positive).
If any bit is 0 → “definitely not present.”

Security / privacy
Bloom filter never stores raw password or hash — only bit positions.
Safe to use with password hashes for leak detection.

// here there are manu real-life example where we can using bloomfilter


	
	*/
}
