package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.repository.UserRepository;

/**
 * ユーザーを登録するサービス.
 * 
 * @author iidashuhei
 *
 */
@Service
@Transactional
public class RegisterUserService {

	@Autowired
	public UserRepository repository;
	
	/**
	 * ユーザーを登録する.
	 * 
	 * @param user ユーザー
	 */
	public void insert(User user) {
		repository.insert(user);
	}
	/**
	 * メールからユーザー情報をとってくる.
	 * 
	 * @param email メール
	 * @return ユーザー情報
	 */
	public User findByEmail(String email) {
		return repository.findByEmail(email);
	}
	
}
