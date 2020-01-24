package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Article;
import com.example.repository.ArticleRepository;

/**
 * 記事詳細を表示するサービス.
 * 
 * @author iidashuhei
 *
 */
@Service
@Transactional
public class ArticleDetailService {

	@Autowired
	private ArticleRepository repository;
	
	/**
	 * 記事の詳細を表示する.
	 * 
	 * @param id ID
	 * @return 詳細記事
	 */
	public Article showArticleDetail(Integer id) {
		return repository.load(id);
	}
}