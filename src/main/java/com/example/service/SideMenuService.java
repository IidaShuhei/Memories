package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Review;
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
	public List<Review> showReviewList(){
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
	
}
