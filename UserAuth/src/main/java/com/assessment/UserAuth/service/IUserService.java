package com.assessment.UserAuth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.assessment.UserAuth.entity.User;

@Service
public interface IUserService {
	public User addUser(User user);
	public List<User> getAllUsers();
	public Optional<User> getUserByEmail(String email);
}
