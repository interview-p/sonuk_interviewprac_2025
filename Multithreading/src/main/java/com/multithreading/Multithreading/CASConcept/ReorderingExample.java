package com.multithreading.Multithreading.CASConcept;

public class ReorderingExample {

	 static boolean ready = false; // no volatile
	    static int  data = 0;

	    public static void main(String[] args) throws InterruptedException {

	        for (int i = 0; i < 10; i++) {

	        	System.out.println("enter in forloop index"+i);
	            data = 0;
	           // ready = false;

	            Thread writer = new Thread(() -> {
	            	System.out.println("enter in writer ");
	            //	ready = true;
	                data = 42;      // (1)
	                // Force delay to simulate long write
	                try { 
	                	Thread.sleep(100); 
	                } catch (Exception e) {}
	                ready = true;   // (2)
	            });

	            Thread reader = new Thread(() -> {
	            	System.out.println("enter in reader");
	                while (!ready) {
	                    // spin fast
	                    Thread.yield(); // give scheduler hint
	                }
	                if (data == 0) {
	                    System.out.println("Reordering happened! data = " + data);
	                    System.exit(0); // stop after first failure
	                }
	            });

	            writer.start();
	            reader.start();
	            writer.join();
	            reader.join();
	        }

	        System.out.println("No reordering observed in this run");
	    }
	    
	    /*
	     * Re-ordering mean jvm does not gurantee order of execution of variable
	     * like if we write 
	     * data = 42 
	     * ready = true
	     * jvm may be execute ready first than data if it happen re-ordering block in reader run
	     * 
	     * what happen internally java assign 42 in data but not flush yet till than reader
	     * thread read value and during read time reader thread not follow read barrier
	     * 
	     * so when we use volatile before data jvm guarntee but not 100% data execute first than ready
	     * because when we use volatile jvm internally write above statement like
	     * data = 42
	     * WRITE_BARRIER // mean jvm flush or write data value in memory first than go to next line
	     * ready = true
	     * WRITE_BARRIER // mean jvm write data in memory tha go forward
	     * 
	     * mean jvm must flush the 42 into data than go forward that's why everytime re-ordering not happen
	     * 
	     * but sometime re-ordering happen because it not guarntee
	     */
}
