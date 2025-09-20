package com.microservices.microservices_project_1.memoryLeak;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MemoryLeakExample {

	 // Static list – stays in memory for the lifetime of the JVM
    private static List<byte[]> memoryLeakList = new ArrayList<>();

    public static void check() throws InterruptedException {

        int iteration = 0;
        while (true) {
            // Allocate 1 MB arrays repeatedly
            byte[] block = new byte[1024 * 1024];

            // Add to static list → objects never become unreachable
            memoryLeakList.add(block);

            iteration++;
            System.out.println("Iteration: " + iteration + " - Heap used: " + (memoryLeakList.size()) + " MB");

            // Sleep a bit to slow down allocation
            Thread.sleep(100);
        }
    }
    
}
