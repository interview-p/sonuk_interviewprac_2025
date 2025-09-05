package com.grpc.grpcDemo.grpcController;


import org.springframework.grpc.server.service.GrpcService;

import com.grpc.grpcDemo.Entity.UserEntity;
import com.grpc.grpcDemo.Service.UserService;

import io.grpc.stub.StreamObserver;
import user.User.CreateUserRequest;
import user.User.GetUserRequest;
import user.User.UserResponse;
import user.UserServiceGrpc;

@GrpcService
public class UserGrpcService extends UserServiceGrpc.UserServiceImplBase{

	
	 private final UserService userService;

	    public UserGrpcService(UserService userService) {
	        this.userService = userService;
	    }
	    
	 
	 
	    @Override
	    public void createUser(CreateUserRequest req, StreamObserver<UserResponse> responseObserver) {
	        UserEntity user = userService.create(req.getName(), req.getEmail(), req.getEmail());
	        UserResponse reply = UserResponse.newBuilder()
	                .setId(user.getId())
	                .setName(user.getName())
	                .setEmail(user.getEmail())
	                .build();
	        responseObserver.onNext(reply);
	        responseObserver.onCompleted();
	    }
	    
	    @Override
	    public void getUserById(GetUserRequest req, StreamObserver<UserResponse> responseObserver) {
	        UserEntity user = userService.getById(req.getId());
	        UserResponse reply = UserResponse.newBuilder()
	                .setId(user.getId())
	                .setName(user.getName())
	                .setEmail(user.getEmail())
	                .build();
	        responseObserver.onNext(reply);
	        responseObserver.onCompleted();
	    }
	    
    
}
