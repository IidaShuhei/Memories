package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.domain.LoginUser;
import com.example.repository.GoodRepository;
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

	@Autowired
	public GoodRepository goodRepository;
	
	@Autowired
	public HttpSession session;

	/**
	 * 記事詳細を表示する.
	 * 
	 * @param id    ID
	 * @param model モデル
	 * @return 記事詳細
	 */
	@RequestMapping("")
	public String showArticleDetail(Integer id, Model model, @AuthenticationPrincipal LoginUser loginUser) {
		
		Integer userId = null;
		Integer preUserId = null;
		
		//登録してあるID
		if (loginUser != null) {
			userId = loginUser.getUser().getUserId();
			
		//セッションに入っているID
		} else if (session.getAttribute("userId") != null) {
			preUserId = (Integer) session.getAttribute("userId");
			
		//自動採番のID
		} else {
			String source = session.getId();
			preUserId = source.hashCode();
		}
		
		Article article = service.showArticleDetail(id);
		model.addAttribute("article", article);
		model.addAttribute("good", goodRepository.good(article.getId()));
		model.addAttribute("userId", userId);
		model.addAttribute("preUserId", preUserId);
		return "article_detail";
	}
}
