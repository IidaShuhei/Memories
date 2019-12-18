package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.LoginForm;
import com.example.service.LoginService;

@Controller
@RequestMapping("")
public class LoginController {

	@Autowired
	private HttpSession session;

	@Autowired
	private LoginService service;

	@RequestMapping("")
	public String index() {
		return "login";
	}

	/**
	 * メールアドレスとパスワードが一致したらログイン成功、
	 * それ以外はログイン失敗.
	 * @param form
	 * @param model
	 * @param result
	 * @return
	 */
	@RequestMapping("/login")
	public String Login(@Validated LoginForm form, Model model, BindingResult result) {
		User user = service.login(form.getEmail(), form.getPassword());
		if (result.hasErrors()) {
			return index();
		}
		if (user == null) {
			model.addAttribute("message", "メール又はパスワードが不正です");
			return "login";
		}
		session.setAttribute("UserName", user.getName());
		return "article_list";

	}

}
