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
	       
	        
	   
	   
	   
	   
	   
	   
	   
	4> will continue later some topic - grpc is framework like springboot it is king of bean inside 
	   of springboot,is protobuf is same as grpc, after adding net dev dependency server not start
	   
	 
	
	*/
}
