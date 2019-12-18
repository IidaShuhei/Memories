package com.example.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Base64;
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
	
	@RequestMapping("")
	public String index() {
		return "article_list";
	}

	/**
	 * 記事を曖昧検索する.
	 * 
	 * @param name 名前
	 * @param model モデル
	 * @return 記事一覧
	 */
	@RequestMapping("/findByName")
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
	 * @throws IOException 
	 */
	@RequestMapping("/registerArticle")
	public String RegisterArticle(ArticleForm articleForm,Model model) throws IOException {
		Article article = new Article();
		article.setTitle(articleForm.getTitle());
		article.setName(articleForm.getName());
		article.setContent(articleForm.getContent());
		LocalDate localDate = LocalDate.now();
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		article.setPostDate(date);
		
		System.err.println("article="+ article);
		
		byte[] encoded = Base64.getEncoder().encode(articleForm.getImagePath().getBytes());
		Charset charset = StandardCharsets.UTF_8;
		
		String base64 = new String(encoded, charset);
		String fileExtension = articleForm.getImagePath().getOriginalFilename().substring(articleForm.getImagePath().getOriginalFilename().length() - 3);
		StringBuilder base64image = new StringBuilder();
		if("jpg".equals(fileExtension)) {
			base64image.append("data:image/jpeg;base64,");
		}
		if("png".equals(fileExtension)) {
			base64image.append("data:image/png;base64,");
		}
		base64image.append(base64);
		article.setImagePath(base64image.toString());
	    service.registerArticle(article);
	    
	    System.err.println("articleの中身"+ article);
	    
	    return "forward:/";
	}
	
	@RequestMapping("/practice")
	public String index1() {
		return "practice";
	}
	
	@RequestMapping("/testDetail")
	public String testIndex(Integer id, Model model) {
		model.addAttribute("article", service.showDetail(id));
		return "testDetail";
	}
}
