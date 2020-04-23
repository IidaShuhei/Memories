package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.repository.LoginRepository;

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

	
	/**パスワードからユーザー情報をとってくる.
	 * @param password パスワード
	 * @return
	 */
	public User findByPassword(String password) {
		return repository.findByPassword(password);
	}
	


}