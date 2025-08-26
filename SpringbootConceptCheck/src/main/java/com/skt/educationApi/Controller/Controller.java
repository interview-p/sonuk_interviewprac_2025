package com.skt.educationApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skt.educationApi.AvailbilityChangeEvent.MaintenanceService;

@RestController
@RequestMapping("/springconcept")
public class Controller {

	@Autowired
	private MaintenanceService mainService;
	
	
	@GetMapping("/stopservice")
	public ResponseEntity<String> stopServices() {
	    
		mainService.startMaintenance();
		return (ResponseEntity<String>) ResponseEntity.ok("service stop");
		
	}	
	
	@GetMapping("/check")
	public ResponseEntity<String> check() {
	    
		return (ResponseEntity<String>) ResponseEntity.ok("checking");
		
	}
}
