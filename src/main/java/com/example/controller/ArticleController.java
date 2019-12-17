package com.example.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.form.ArticleForm;
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
	
	/**
	 * 記事を投稿する.
	 * @param articleForm
	 * @param model
	 * @return　記事一覧
	 */
	@RequestMapping("/registerArticle")
	public String RegisterArticle(ArticleForm articleForm,Model model) {
		Article article = new Article();
		article.setId(Integer.parseInt(articleForm.getId()));
		article.setTitle(articleForm.getTitle());
		article.setName(articleForm.getName());
		article.setContent(articleForm.getContent());
		LocalDate localDate = LocalDate.now();
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		article.setPostDate(date);
		article.setImagePath(articleForm.getImagePath());
	    service.registerArticle(article);
	    
	    return "article_List";
	}
	
	@RequestMapping("/practice")
	public String index() {
		return "practice";
	}
}
