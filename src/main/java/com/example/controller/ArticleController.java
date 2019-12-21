package com.example.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.form.ArticleForm;
import com.example.service.ArticleDetailService;
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
	
	@Autowired
	private ArticleDetailService detailService;
	
	@ModelAttribute
	private ArticleForm setUpForm() {
		return new ArticleForm();
	}

	/**
	 * 記事を全件検索する.
	 * 
	 * @param model モデル
	 * @return 全件検索結果
	 */
	@RequestMapping("")
	public String findAll(Model model) {
		List<Article> articleList = service.findAll();
		model.addAttribute("articleList", articleList);
		return "article_list";
	}

	/**
	 * 記事をタイトルから曖昧検索する.
	 * 
	 * @param title タイトル
	 * @param model モデル
	 * @return 記事一覧
	 */
	@RequestMapping("/findByTitle")
	public String findByTitle(String title, Model model) {
		List<Article> articleList = service.showArticleListFindByTitle(title);
		model.addAttribute("articleList", articleList);
		return "article_list";
	}
	/**
	 * 記事を投稿者名から曖昧検索する.
	 * 
	 * @param name  名前
	 * @param model モデル
	 * @return 記事一覧
	 */
	@RequestMapping("/findByName")
	public String findByName(String name, Model model) {
		List<Article> articleList = service.showArticleListFindByName(name);
		model.addAttribute("articleList", articleList);
		return "article_list";
	}
	/**
	 * 記事を内容から曖昧検索する.
	 * 
	 * @param name  名前
	 * @param model モデル
	 * @return 記事一覧
	 */
	@RequestMapping("/findByContent")
	public String findByContent(String content, Model model) {
		List<Article> articleList = service.showArticleListFindByContent(content);
		model.addAttribute("articleList", articleList);
		return "article_list";
	}
	/**
	 * 記事を投稿する画面.
	 * 
	 * @return 記事を投稿する画面へ遷移
	 */
	@RequestMapping("/insert")
	public String insert() {
		return "insertArticle";
	}
	/**
	 * 記事を投稿する.
	 * 
	 * @param articleForm 記事フォーム
	 * @param model モデル
	 * @return　記事一覧
	 * @throws IOException 
	 */
	@RequestMapping("/registerArticle")
	public String RegisterArticle(ArticleForm articleForm,Model model) throws IOException {
		Article article = new Article();
		article.setTitle(articleForm.getTitle());
		article.setName(articleForm.getName());
		article.setPrefecture(articleForm.getPrefecture());
		article.setContent(articleForm.getContent());
		LocalDate localDate = LocalDate.now();
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		article.setPostDate(date);
		
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
	    
	    return "forward:/";
	}
	
	/**
	 * 編集画面へ遷移.
	 * 
	 * @return　編集画面
	 */
	@RequestMapping("/updateScreen")
	public String updateScreen(Integer id,Model model) {
		Article article = detailService.showArticleDetail(id);
		model.addAttribute("article", article);
		return "updateArticle";
	}
	
	/**
	 * 記事を更新する.
	 * 
	 * @param articleForm 記事フォーム
	 * @param model　モデル
	 * @return　編集画面
	 */
	@RequestMapping("/update")
	public String update(ArticleForm articleForm,Model model) {
		
		System.err.println(articleForm.getContent());
		
		Article article = new Article();
		BeanUtils.copyProperties(articleForm, article);
		
		
		System.err.println(article);
	
		
		service.update(article);
		//Date型をString型へ変換
//		String day = articleForm.getPostDate();
//		Date date = Date.valueOf(day);
//		article.setPostDate(date);
		return "forward:/";
	}
}