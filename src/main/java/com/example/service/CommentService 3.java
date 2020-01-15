package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Comment;
import com.example.repository.CommentRepository;

/**
 * コメント機能のサービス.
 * 
 * @author iidashuhei
 *
 */
@Service
@Transactional
public class CommentService {

	@Autowired
	private CommentRepository repository;
	
	/**
	 * 記事IDからコメントを探してくる.
	 * 
	 * @param articleId 記事ID
	 * @return コメント
	 */
	public List<Comment> findByArticleId(Integer articleId){
		return repository.findByArticleId(articleId);
	}
	
	/**
	 * コメントを挿入する.
	 * 
	 * @param comment コメント
	 */
	public void insert(Comment comment) {
		repository.insert(comment);
	}
	
	/**
	 * 記事IDからコメントを削除する.
	 * 
	 * @param articleId 記事ID
	 */
	public void deleteByArticleId(Integer articleId) {
		repository.deleteByArticleId(articleId);
	}
}
