package com.java.practice.JavaPractice.javaGeneric;

public class Note {

	/*

------------------------------------------------------------------------

	 when we write like
	 
	 class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

-------java compiler convert it into 

class Box {
    private Object value;

    public void set(Object value) {
        this.value = value;
    }

    public Object get() {
        return value;
    }
}

Box<String> box = new Box<>();
when we write this it automatically convert box.get() into
String s = (String) box.get();

-------------------------------------
	 /*
	    <?> and <T>
	    
<?> → UNKNOWN type
<T> → CONSISTENT type

for <?> - 
Type is unknown
Compiler makes no promises
You cannot add anything

for <T> -
T is one specific type
Compiler guarantees consistency

mean <?> provide flexibility and <T> provide Type Linking
	  */
}
