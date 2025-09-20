package com.microservices.microservices_project_1.memoryLeak;

import org.springframework.stereotype.Component;

@Component
public class EdenSpaceExample {

	public void check() throws InterruptedException {
        while (true) {
            // Create many short-lived objects
            for (int i = 0; i < 1000; i++) {
                byte[] block = new byte[1024 * 50]; // 50 KB
                // Not adding to any list → no references after loop
            }

            System.out.println("Batch of objects created...");

            // Sleep a little so you can see the effect in Visual GC
            Thread.sleep(200);
        }
    }
	
}
