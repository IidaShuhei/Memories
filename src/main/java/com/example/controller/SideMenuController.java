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
import com.example.form.ReviewForm;
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
	 * 使い方のページを表示.
	 * 
	 * @return 使い方のページ
	 */
	@RequestMapping("")
	public String index() {
		return "how_to";
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
		return "review";
	}
	
	/**
	 * レビューを送信する.
	 * 
	 * @param reviewForm レビューフォーム
	 * @return レビュー送信
	 */
	@RequestMapping("/insertReview")
	public String insertReview(@Validated ReviewForm reviewForm, BindingResult result) {
		
		System.out.println(reviewForm);
		
		if (result.hasErrors()) {
			return review();
		}
		Review review = new Review();
//		BeanUtils.copyProperties(reviewForm, review);
		review.setStar(Integer.parseInt(reviewForm.getStar()));
		review.setReviewTitle(reviewForm.getReviewTitle());
		review.setMessage(reviewForm.getMessage());
		System.err.println(reviewForm);
		
		service.insert(review);
		return "review_finished";
	}
}
