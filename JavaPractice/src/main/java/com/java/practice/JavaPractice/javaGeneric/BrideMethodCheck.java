package com.java.practice.JavaPractice.javaGeneric;

public class BrideMethodCheck {

	public static void main(String[] args) {
		
		BridgeParent obj = new BridgeChild();
		System.out.println(obj.getValue());
		
		/*
		 here what happen internally if you can see in parent class it is like
		 public T getValue() {
		    return (T)"parent";
	     }
	     
	     it is convert it public Object getvalue() mean T replace with object . and we extend
	     parent into child one bride method created by compiler into child like
	     
	     public Object getvalue(){
	        return getvalue() // child class method
	      }
	      
	     so when we call obj.getvalue() internally it call the bridge method as per polimorphism
	     according to rule it retur "parent" in response but not because in bride method 
	     it call child class getvalue() method so that it maintain generic implemetation
	     if bride method do not do this Generic inheritance becomes meaningless
	     
	     
		 Bridge method overrides the parent method and delegates to the child’s real method — never the other way around.
		 */

	}

}
