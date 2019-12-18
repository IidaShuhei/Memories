package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository repository;
	
	public User login(String email,String password) {
    User user = repository.findByemailAndPassword(email, password);
		
		return user;
		
	}
	

}
