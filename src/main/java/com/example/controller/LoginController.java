package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.LoginForm;
import com.example.service.LoginService;

@Controller
@RequestMapping("")
public class LoginController {
	
	@ModelAttribute
	public LoginForm setUpForm() {
		return new LoginForm();
	}

	@Autowired
	private HttpSession session;

	@Autowired
	private LoginService service;

	@RequestMapping("/log")
	public String index() {
		return "login";
	}

	/**
	 * メールアドレスとパスワードが一致したらログイン成功させ記事一覧にとぶ、
	 * それ以外はログイン失敗させ、ログイン画面に戻す.
	 * @param form
	 * @param model
	 * @param result
	 * @return
	 */
	@RequestMapping("/login")
	public String Login(@Validated LoginForm form, BindingResult result,Model model) {
		if (result.hasErrors()) {
			return index();
		}
		User user = service.login(form.getEmail(), form.getPassword());
		System.err.println("userの中身"+user);
		if (user == null) {
			model.addAttribute("fail", "メール又はパスワードが不正です");
			return index();
		}
		session.setAttribute("userName", user.getName());
		System.err.println(user.getName());
		return "article_list";

	}

}
