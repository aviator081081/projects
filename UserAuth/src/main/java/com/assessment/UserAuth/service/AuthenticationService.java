package com.assessment.UserAuth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.assessment.UserAuth.config.CustomUserDetails;
import com.assessment.UserAuth.config.JwtService;
import com.assessment.UserAuth.entity.AuthenticationRequest;
import com.assessment.UserAuth.entity.AuthenticationResponse;
import com.assessment.UserAuth.entity.RegisterRequest;
import com.assessment.UserAuth.entity.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	@Autowired
	private final AuthenticationManager authenticationManager;
	
	@Autowired 
	private final IUserService userService;
	
	@Autowired 
	private final JwtService jwtService;
	
	@Autowired
	private final PasswordEncoder passwordEncoder;
	
	public AuthenticationResponse register(RegisterRequest request) {
		
		var user = User.builder()
				.email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword()))
				.role(request.getRole())
				.build();
		
		
		userService.addUser(user);
		UserDetails userDetails = new CustomUserDetails(user);
		var jwtToken = jwtService.generateToken(userDetails);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}

	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		User user = userService.getUserByEmail(request.getEmail()).orElseThrow();
		UserDetails userDetails = new CustomUserDetails(user);
		var jwtToken = jwtService.generateToken(userDetails);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}
}
