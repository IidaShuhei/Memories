package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class LogoutController {
	
	@RequestMapping("/logout")
	public String logout() {
		return "redirect:/log";
	}

}
