package com.grpc.grpcDemo.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "grpcuser")
public class UserEntity {

	    @Id 
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    private String name;
	    private String email;
	    private String addresh;
	       
	    
	    
		public UserEntity() {
			super();
		}
		public UserEntity(String name, String email, String addresh) {
			super();
			this.name = name;
			this.email = email;
			this.addresh = addresh;
		}
		public String getAddresh() {
			return addresh;
		}
		public void setAddresh(String addresh) {
			this.addresh = addresh;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
	    
	    
	    
	    
	    
}
