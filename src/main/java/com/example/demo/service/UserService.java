package com.example.demo.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepo;
	private final PasswordEncoder passwordencoder;
	public UserService(UserRepository userRepo, PasswordEncoder passwordencoder) {
		super();
		this.userRepo = userRepo;
		this.passwordencoder = passwordencoder;
	}
	
	public User register(String username, String rawpassword, String role) {
		if(userRepo.existsByUsername(username)) {
			throw new RuntimeException("username already exits");
		}
		String hashcode=passwordencoder.encode(rawpassword);
		User u= new User(username,hashcode,role);
		return userRepo.save(u);
		
		}
	public Optional<User> findByUsername(String username) {
		return userRepo.findByUsername(username);
	}
	}
	

