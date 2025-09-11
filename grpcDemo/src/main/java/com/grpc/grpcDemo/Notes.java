package com.grpc.grpcDemo;

public class Notes {

	/*
	1> grpc is protocol based on http/2 which support data transmission in binary(fast) and support 
	   multiplexing(bi-directional)
	   
	2> rest use http/1 which support single plex and transmit data in plain text(json)
	
	3> grpc is fast becoz it support binary tranmission when we do transmit data spring convert 
	   or say seliaze in json formate(text maapping) which is slow
	 
	4> why use of grpc over rest
	
	   a> Code generation → gRPC generates client stubs in different languages, so instead of hand-writing REST 
	      calls (with headers, JSON, etc.), you just call a method like it’s local
	   b> Strict contracts → .proto file defines request/response structure. If the client/server 
	      don’t match, it won’t compile → fewer runtime surprises.
	      
	      
	 5> if we want to call grpc withing rest application we put some grpc dependency 
	       and protoc plugin still we get and error artifact not found beacause we not mentation
	       <artifactId>os-maven-plugin</artifactId> which let know maven decide to donwload
	       protoc compiler for operating system you use in your system
	       if it detected window in your system it download window protoc binary(pre-execute source code) 
	       compiler to compile .proto file same if linux found it donwload linux protoc
	       
	 6> It’s a way for a program to call a function on another computer (remote server) as if it were calling a local function.
	       
	 7> gRPC is not a full-fledged application framework like Spring Boot or Django.
        It is a high-performance RPC system (library + protocol + tooling) developed by Google
        
     8> It defines how clients and servers talk using:
            Protocol Buffers (serialization format).
            HTTP/2 (transport layer).
            Generated client/server stubs (code you use in apps).
	   
	 
	 
	
	*/
}
