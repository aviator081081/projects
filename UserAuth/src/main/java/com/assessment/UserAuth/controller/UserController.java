package com.assessment.UserAuth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.UserAuth.entity.User;
import com.assessment.UserAuth.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<?> userRegister(@RequestBody User user){
	
		 User savedUser = userService.addUser(user);
		 return ResponseEntity.ok(savedUser);
		 
		
	}
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllRegisteredUsers(){
		List<User> userList = userService.getAllUsers();
		return ResponseEntity.ok(userList);
	}
	
	@GetMapping("/test")
	public String test() {
		return "test";
	}
	
}
