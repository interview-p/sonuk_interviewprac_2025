package com.skt.educationApi.serialzation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {

	public static void main(String[] args) {
        String filename = "student.ser";
        SerializationDemo obj = new SerializationDemo();
        
        //obj.serializationcheck(filename);
        obj.deserialzationcheck(filename);
        
        //note:- first serialize -> change serial versionid 1 to 2 -> than de-serialze it through error
                 //because jvm maintain object serial version
        
    }
	
	public void serializationcheck(String fileName) {
		
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            Student s1 = new Student(101, "Sonu", "mySecret123");
            out.writeObject(s1);
            System.out.println("✅ Object serialized: " + s1.name);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public void deserialzationcheck(String fileName) {
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            Student s2 = (Student) in.readObject();
            System.out.println("✅ Object deserialized: " + s2.name + ", password = " + s2.password);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
	}
	
}
