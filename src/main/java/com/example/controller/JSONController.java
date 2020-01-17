package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.service.RegisterUserService;

/**
 * JSON形式で受け取るコントローラー.
 * 
 * @author iidashuhei
 *
 */
@RestController
public class JSONController {

	@Autowired
	private RegisterUserService service;

	/**
	 * メールを返す.
	 * 
	 * @param email メール
	 * @return メールアドレス
	 */
	@RequestMapping("/judge")
	public User emailReturn(String email) {
		User user = service.findByEmail(email);
		
		System.out.println(" 1 : " + user);
		
		if(user == null) {
			user = new User();
			System.out.println(" 2 : " + user);
		}
		return user;
	}
}
