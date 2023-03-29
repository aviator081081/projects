package com.assessment.UserAuth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	//public Api :User with 'read' permissions can access this api 
	@GetMapping("/read")
	public ResponseEntity<String> publicApi(){
		return ResponseEntity.ok("read");
	}
	
	
	//private Api :User with 'write' permissions can access this api 
	@GetMapping("/write")
	public ResponseEntity<String> privateApi(){
		return ResponseEntity.ok("write");
	}
	
}
