package com.assessment.UserAuth.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

	private String email;
	private String password;
	private Role role;
}
