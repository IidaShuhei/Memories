package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.UserForm;
import com.example.service.RegisterUserService;

/**
 * ユーザー登録をするコントローラー.
 * 
 * @author iidashuhei
 *
 */
@Controller
@RequestMapping("/register")
public class RegisterUserController {
	
	/**
	 * 入力値チェックの際に必要.
	 * 
	 * @return ユーザーフォーム
	 */
	@ModelAttribute
	private UserForm setUpForm() {
		return new UserForm();
	}
	
	@Autowired
	private RegisterUserService service;
	
	/**
	 * 登録画面へ遷移.
	 * 
	 * @return 
	 */
	@RequestMapping("")
	public String index() {
		return "register_user";
	}
	
	/**
	 * ユーザー情報を登録する.
	 * 
	 * @param userForm ユーザーフォーム
	 * @return ユーザー情報
	 */
	@RequestMapping("/insert")
	public String insert(UserForm userForm,  Model model) {
		User user = new User();
		BeanUtils.copyProperties(userForm, user);
		service.insert(user);
		return "login";
	}
}