package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	private final UserRepository userRepo;

	public CustomUserDetailsService(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var user=userRepo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("user not found"));
		String role=user.getRole();
		String rolewithoutprefix=role.startsWith("ROLE_")? role.substring(5):role;
		return org.springframework.security.core.userdetails.User
				.withUsername(user.getUsername()).password(user.getPassword())
				.roles(rolewithoutprefix).build();
	}
	
}
