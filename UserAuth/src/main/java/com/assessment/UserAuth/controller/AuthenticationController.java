package com.assessment.UserAuth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.UserAuth.entity.AuthenticationRequest;
import com.assessment.UserAuth.entity.RegisterRequest;
import com.assessment.UserAuth.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService service;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody RegisterRequest request){
		return ResponseEntity.ok(service.register(request));
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request){
		return ResponseEntity.ok(service.authenticate(request));
	}
}
