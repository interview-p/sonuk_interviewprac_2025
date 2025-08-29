package com.skt.educationApi.serialzation;

public class Notes {

	/*
	serialzation -> basically do to convert java object into file ,json,xml
	    
	    1> java in-build serialzation basicaly covert object into file
	    2> or we can say it is used to preserve object state when we need previous state we can use it
	    
	    step-by-step process how jvm can do the serialzation
	    
	    1> JVM first checks class implement serialzation interface or not bcoz it is marker interface
	       which let know jvm it is class which make in serialzable
	       
	    2> Write Stream Header:
	        1> ObjectOutputStream writes some metadata (magic number, version, etc.) to the file/stream.
               Example: AC ED 00 05 → stream magic & version.
               
        3> Check for Already Serialized Objects (Handle Table)
           JVM maintains an object handle table to avoid duplicate serialization.
           If object already written → only reference (handle ID) is written.
           This prevents infinite loops with circular references.
           
        4> Serialize Class Metadata
            	The following metadata about the class is written:
             Fully qualified class name
             serialVersionUID
              Field descriptions (type + name)
              
        5. Serialize Field Values
            Each non-transient, non-static field is serialized:
            Primitive fields → written as raw values.
            Object fields → recursively call writeObject() on them.
            If a field is transient → skipped.
            If a field is static → not part of object state, so skipped too.
            
         7. Write End of Object Block
             JVM writes a block marker indicating end of object.
             Then moves to the next object (if any).
             
             
the hexdump create while data push in file is 
      
      AC ED 00 05 73 72 00 07 53 74 75 64 65 6E 74
 00 00 00 01 02 00 02 49 00 02 69 64 4C 00 04
 6E 61 6D 65 74 00 12 4C 6A 61 76 61 2F 6C 61
 6E 67 2F 53 74 72 69 6E 67 3B 78 70 00 00 00
 65 74 00 04 53 6F 6E 75
 
 
 how to interpret-
 
 AC ED → Stream magic (identifies this as a Java serialization stream).

00 05 → Stream version.

73 → Object indicator.

72 → Class descriptor indicator.

00 07 → Length of class name = 7.

53 74 75 64 65 6E 74 → UTF string = "Student".

00 00 00 01 → serialVersionUID.

02 → Number of fields = 2.

49 00 02 69 64 → Field: type = I (int), name = "id".

4C ... String; → Field: type = L (object reference), name = "name".

78 → End of class descriptor.

70 → Null reference marker.

00 00 00 65 → Value of id = 101.

74 00 04 53 6F 6E 75 → UTF string "Sonu".
	
	
	*/
}
