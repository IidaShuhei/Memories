package com.example.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Review;
import com.example.form.ContactForm;
import com.example.form.ReviewForm;
import com.example.form.SortForm;
import com.example.service.SideMenuService;

/**
 * サイドメニューを管理するコントローラー.
 * 
 * @author iidashuhei
 *
 */
@Controller
@RequestMapping("/sideMenu")
public class SideMenuController {
	
	@Autowired
	private SideMenuService service;
	
	@ModelAttribute
	private ReviewForm setUpForm() {
		return new ReviewForm();
	}

	/**
	 * 質問ページを表示.
	 * 
	 * @return 質問ページ
	 */
	@RequestMapping("/question")
	public String question() {
		return "question";
	}
	
	/**
	 * 問い合わせを送信する.
	 * 
	 * @param contactForm 問い合わせフォーム.
	 * @return 問い合わせを送信
	 */
	@RequestMapping("/sendQuestion")
	public String sendQuestion(ContactForm contactForm) {
		service.sendMail(contactForm);
		return "question_finished";
	}
	
	/**
	 * 評価ページを表示.
	 * 
	 * @return 評価ページ
	 */
	@RequestMapping("/review")
	public String review() {
		return "review";
	}
	
	/**
	 * レビュー一覧を表示する.
	 * 
	 * @return レビュー一覧
	 */
	@RequestMapping("/showReviewList")
	public String showReviewList(Model model) {
		List<Review> reviewList = service.showReviewList();
		model.addAttribute("reviewList", reviewList);
		return "review_list";
	}
	
	/**
	 * レビューを送信する.
	 * 
	 * @param reviewForm レビューフォーム
	 * @return レビュー送信
	 */
	@RequestMapping("/insertReview")
	public String insertReview(@Validated ReviewForm reviewForm, BindingResult result) {
		if (result.hasErrors()) {
			return review();
		}
		Review review = new Review();
		BeanUtils.copyProperties(reviewForm, review);
		review.setStar(Integer.parseInt(reviewForm.getStar()));
		
		service.insert(review);
		return "review_finished";
	}
	
	/**
	 * 評価が高い順、低い順で並び替える.
	 * 
	 * @param sortForm ソートフォーム
	 * @param model モデル
	 * @return 評価が高い順、低い順
	 */
	@RequestMapping("/findByStar")
	public String findByStar(SortForm sortForm, Model model) {
		List<Review> reviewList = service.findByStar(sortForm);
		model.addAttribute("reviewList", reviewList);
		return "review_list";
	}
}
