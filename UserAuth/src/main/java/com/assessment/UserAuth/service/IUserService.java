package com.assessment.UserAuth.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.assessment.UserAuth.entity.User;

@Service
public interface IUserService {
	public User addUser(User user);
	public List<User> getAllUsers();
}
