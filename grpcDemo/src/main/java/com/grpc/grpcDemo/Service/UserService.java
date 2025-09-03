package com.grpc.grpcDemo.Service;

import org.springframework.stereotype.Service;

import com.grpc.grpcDemo.Entity.UserEntity;
import com.grpc.grpcDemo.UserRepository.UserRepository;

@Service
public class UserService {

	private final UserRepository repo;
	
    public UserService(UserRepository repo) { this.repo = repo; }

    public UserEntity create(String name, String email, String addresh) {
        return repo.save(new UserEntity(name, email, addresh));
    }

    public UserEntity getById(int id) {
        return repo.findById(id).orElseThrow();
    }
    
}
