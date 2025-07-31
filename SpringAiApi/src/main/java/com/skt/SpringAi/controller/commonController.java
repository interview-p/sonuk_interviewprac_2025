package com.skt.SpringAi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skt.SpringAi.BusinessLogic.BusinessLogic;
import com.skt.SpringAi.Request.EncryptedRequest;
import com.skt.SpringAi.Response.EncryptedResponse;

@RestController
@RequestMapping("/education")
public class commonController {

	@Autowired
	private BusinessLogic bl;
	
	@GetMapping("/admin1")
	public ResponseEntity<String> getAdminDetails1() {
			
		 return ResponseEntity.ok("Hello Admin1 your config properties value ");
		
	}
	
	@PostMapping("/encrypted")
	public EncryptedResponse encryptedData(@RequestBody EncryptedRequest request) throws Exception {
			
		 return bl.encryptRequest(request);
		
	}
	
	@PostMapping("/decrypted")
	public EncryptedResponse decryptedData(@RequestBody EncryptedRequest request) throws Exception {
			
		 return bl.decryptRequest(request);
		
	}
	
	
}

