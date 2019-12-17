package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.service.ArticleService;

/**
 * 記事を表示するコントローラー.
 * 
 * @author iidashuhei
 *
 */
@Controller
@RequestMapping("/")
public class ArticleController {

	@Autowired
	private ArticleService service;

	/**
	 * 記事を曖昧検索する.
	 * 
	 * @param name 名前
	 * @param model モデル
	 * @return 記事一覧
	 */
	@RequestMapping("")
	public String findByName(String name, Model model) {
		List<Article> articleList = service.showArticleListFindByName(name);
		if (articleList.isEmpty()) {
			articleList = service.findAll();
		} else {
			articleList = service.showArticleListFindByName(name);
		}
		model.addAttribute("articleList", articleList);
		return "article_list";
	}
}
