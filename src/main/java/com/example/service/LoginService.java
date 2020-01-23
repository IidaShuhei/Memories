package com.example.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.LoginUser;
import com.example.domain.User;
import com.example.repository.LoginRepository;
import com.example.repository.UserRepository;

@Service
@Transactional
public class LoginService{

	@Autowired
	private LoginRepository repository;


	/**
	 * メールとパスワードからユーザー情報を取得する.
	 * 
	 * @param email    メール
	 * @param password パスワード
	 * @return ユーザー情報
	 */
	public User login(String email, String password) {
		User user = repository.findByemailAndPassword(email, password);
		return user;
	}

}