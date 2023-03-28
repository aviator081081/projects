package com.assessment.UserAuth.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.assessment.UserAuth.entity.User;
import com.assessment.UserAuth.repo.UserRepo;
@Service
public class UserServiceImpl implements IUserService{

	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User addUser(User user) {
		
		Optional<User> oUser = userRepo.findByEmail(user.getEmail());
		if(oUser.isPresent()) {
			//throw new UserAlreadyPresentException();
		}
		return userRepo.save(user);
		
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepo.findAll();
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
		
		return userRepo.findByEmail(email);
	}

}
