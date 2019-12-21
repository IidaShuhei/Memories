package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 北海道を表示するコントローラー.
 * 
 * @author iidashuhei
 *
 */
@Controller
@RequestMapping("hokkaido")
public class Hokkaido {

	@RequestMapping("Tohokkaido")
	public String index() {
		return "hokkaido";
	}
}
