package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Article;
import com.example.repository.ArticleRepository;

@Service
@Transactional
public class ArticleService {

	@Autowired
	private ArticleRepository repository;
	
	/**
	 * 記事一覧を表示する.
	 * 
	 * @return 記事一覧
	 */
	public List<Article> findAll(){
		return repository.findAll();
	}

	/**
	 * 記事をタイトルから曖昧検索する.
	 * 
	 * @param title タイトル
	 * @return 全件検索結果、曖昧検索結果
	 */
	public List<Article> showArticleListFindByTitle(String title) {
		return repository.findByTitle(title);
	}
	/**
	 * 記事を投稿者名から曖昧検索する.
	 * 
	 * @param name 名前
	 * @return 全件検索結果、曖昧検索結果
	 */
	public List<Article> showArticleListFindByName(String name) {
		return repository.findByName(name);
	}
	/**
	 * 記事を内容から曖昧検索する.
	 *
	 * @param content 内容
	 * @return 全件検索結果、曖昧検索結果
	 */
	public List<Article> showArticleListFindByContent(String content) {
		return repository.findByContent(content);
	}
	
	/**
	 *記事情報を登録する.
	 * @param article
	 */
	public void registerArticle(Article article) {
		 repository.insert(article);
	}
	
	public Article showDetail(Integer id) {
		return repository.load(id);
	}
}
