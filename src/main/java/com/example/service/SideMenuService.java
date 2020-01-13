package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Review;
import com.example.form.SortForm;
import com.example.repository.SideMenuRepository;

/**
 * サイドメニューを管理するサービス.
 * 
 * @author iidashuhei
 *
 */
@Service
@Transactional
public class SideMenuService {

	@Autowired
	private SideMenuRepository repository;

	/**
	 * レビュー一覧を表示する.
	 * 
	 * @return レビュー一覧
	 */
	public List<Review> showReviewList() {
		return repository.findAll();
	}

	/**
	 * レビューを挿入する.
	 * 
	 * @param review レビュー
	 */
	public void insert(Review review) {
		repository.insert(review);
	}

	
	/**
	 * 評価が高い順、低い順で並び替える.
	 * 
	 * @param sortForm ソートフォーム
	 * @return 評価が高い順、低い順
	 */
	public List<Review> findByStar(SortForm sortForm) {
		String sort = sortForm.getSort();
		
		System.err.println(sort);
		
		List<Review> reviewList = null;
		if ("high".equals(sort)) {
			reviewList = repository.findByHighStar();
			
			System.out.println(reviewList);
			
		} else if("low".equals(sort)){
			reviewList = repository.findByLowStar();
		}
		return reviewList;
	}
}
