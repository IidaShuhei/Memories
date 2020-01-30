package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.repository.UserRepository;

/**
 * ユーザー情報を管理するサービス.
 * 
 * @author iidashuhei
 *
 */
@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository repository;
	
	/**
	 * ユーザー情報を更新する.
	 * 
	 * @param nickName ニックネーム
	 * @param image 画像
	 */
	public void update(String nickName, String image) {
		repository.update(nickName, image);
	}
	
	/**
	 * idから画像を探してくる.
	 * 
	 * @param id Id
	 * @return ユーザー情報
	 */
	public User findImageById(Integer id) {
		return repository.findImageById(id);
	}
	
}
