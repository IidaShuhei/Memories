package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.RegisterUserService;

@Controller
@RequestMapping("/register")
public class RegisterUserController {

	@Autowired
	private RegisterUserService service;
	
	@RequestMapping("")
	public String index() {
		return "register_user";
	}
}
