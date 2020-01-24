package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.User;
import com.example.repository.LoginRepository;
import com.example.repository.UserRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository repository;
	
	
	public User login(String email,String password) {
    User user = repository.findByemailAndPassword(email, password);
		
		return user;
		
	}
	
	/**パスワードからユーザー情報をとってくる.
	 * @param password パスワード
	 * @return
	 */
	public User firndByPassword(String password) {
		return repository.findByPassword(password);
	}
	

}
