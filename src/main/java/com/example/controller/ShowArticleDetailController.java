package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.domain.LoginUser;
import com.example.service.ArticleDetailService;

/**
 * 記事詳細を表示するコントローラー.
 * 
 * @author iidashuhei
 *
 */
@Controller
@RequestMapping("/showArticleDetail")
public class ShowArticleDetailController {

	@Autowired
	public ArticleDetailService service;
	
	/**
	 * 記事詳細を表示する.
	 * 
	 * @param id ID
	 * @param model モデル
	 * @return 記事詳細
	 */
	@RequestMapping("")
	public String showArticleDetail(Integer id,Model model,@AuthenticationPrincipal LoginUser loginUser) {
		Article article = service.showArticleDetail(id);
		model.addAttribute("article", article);
		
		Integer userId = loginUser.getUser().getUserId();
		model.addAttribute("userId", userId);
		return "article_detail";
	}
}
