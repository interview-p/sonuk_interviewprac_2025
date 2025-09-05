package com.skt.educationApi.callingThirdPartyGrpc;

import org.springframework.stereotype.Service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import user.UserServiceGrpc;
import user.User.CreateUserRequest;
import user.User.GetUserRequest;
import user.User.UserResponse;

@Service
public class GrpcClientService {

	
	private final UserServiceGrpc.UserServiceBlockingStub userStub; // this stub is kind of restTemplate
	 // which mention in userServiceGrpc class which is build during compilation using ptotoc compiler
	

    public GrpcClientService() {
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9091) // gRPC server host:port
                .usePlaintext() // because no TLS in local/dev
                .build();

        this.userStub = UserServiceGrpc.newBlockingStub(channel);
    }

    public String createUser(String name, String email, String addresh) {
      	CreateUserRequest request = CreateUserRequest.newBuilder()
                  .setName(name)
                  .setEmail(email)
                  .setAddresh(addresh)
                  .build();
      	// we can directly call the method not like rest call need url
       UserResponse response = userStub.createUser(request);
       return "success";
    }
    
    public UserResponseModel getUserById(String id) {
     	GetUserRequest req = GetUserRequest.newBuilder()
     			                      .setId(Integer.parseInt(id))
     			                      .build();
     	
     	UserResponse res = userStub.getUserById(req);
     	UserResponseModel req1 = new UserResponseModel();
     	req1.setName(res.getName());
     	req1.setEmail(res.getEmail());
     	req1.setId(res.getId());
     	
     	return req1;
     	
     	
     	
    }
    
}
