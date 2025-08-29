package com.skt.educationApi.serialzation;

import java.io.Serializable;

public class Student implements Serializable {

	 private static final long serialVersionUID = 1L; // recommended

	    int id;
	    String name;
	    transient String password; // will not be serialized

	    public Student(int id, String name, String password) {
	        this.id = id;
	        this.name = name;
	        this.password = password;
	    }
}
