package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Article;
import com.example.domain.User;
import com.example.service.ArticleDetailService;
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
	
	@Autowired
	private ArticleDetailService detailService;

	/**
	 * メールを返す.
	 * 
	 * @param email メール
	 * @return メールアドレス
	 */
	@RequestMapping("/judge")
	public User emailReturn(String email) {
		User user = service.findByEmail(email);
		if(user == null) {
			user = new User();
		}
		return user;
	}
	
	/**
	 * グッドを返す.
	 * 
	 * @param good グッド
	 * @return グッドを返す
	 */
	@RequestMapping("/good")
	public Article update(Integer id,Integer good,Model model) {
		detailService.update(id,good);
		Article article = detailService.showArticleDetail(id);
		model.addAttribute("article",article);
		return article;
	}
}
