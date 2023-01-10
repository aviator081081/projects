package com.example.demo.controller;

import java.security.Principal;

import org.apache.catalina.LifecycleException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping("/1")
	public String test(Principal p) {
		System.out.println("test1");
		return "test1 "+p;
	}
	
//	@GetMapping("/login")
//	public String login() {
//		return "login";
//	} 
	
	@GetMapping("/logout")
	public String logout(HttpSession hs)  {
//		ap.setAuthenticated(false);
		hs.invalidate();
		return "logout";
	} 
	
	
}
