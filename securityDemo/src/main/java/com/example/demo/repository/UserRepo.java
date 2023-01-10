package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String username);

}
