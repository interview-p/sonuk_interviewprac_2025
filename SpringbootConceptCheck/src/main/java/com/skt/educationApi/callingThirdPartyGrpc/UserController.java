package com.skt.educationApi.callingThirdPartyGrpc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/grpc/call")
public class UserController {

	// it call the grpc service
	
	private final GrpcClientService grpcClientService;

    public UserController(GrpcClientService grpcClientService) {
        this.grpcClientService = grpcClientService;
    }

    @PostMapping("/createuser")
    public String createUser(@RequestBody UserRequestModel req) {
        return grpcClientService.createUser(req.getName(), req.getEmail(), req.getAddresh());
    }
    
    @GetMapping("/getuser/{id}")
    public UserResponseModel getUser(@PathVariable String id) {
        return grpcClientService.getUserById(id);
    }
}
