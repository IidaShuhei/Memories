package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Comment;

/**
 * コメントを管理するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Repository
public class CommentRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Comment>COMMENT_ROW_MAPPER = (rs,i) -> {
	
		Comment comment = new Comment();
		comment.setId(rs.getInt("id"));
		comment.setName(rs.getString("name"));
		comment.setContent(rs.getString("content"));
		comment.setArticleId(rs.getInt("articleId"));
		return comment;
	};
	
	/**
	 * 記事IDからコメントを見つける.
	 * 
	 * @param articleId 記事ID
	 * @return コメント
	 */
	public List<Comment> findByArticleId(int articleId){
		String sql = "select id,name,content,article_id from comments where article_id =:articleId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("articleId", articleId);
		return template.query(sql, param, COMMENT_ROW_MAPPER);
	}
	
	/**
	 * コメントを挿入する.
	 * 
	 * @param comment コメント
	 */
	public void insert(Comment comment) {
		String sql = "insert into comments(id,name,content,article_id)values(:id,:name,:content,:articleId)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(comment);
		template.update(sql, param);
	}
	
	/**
	 * 記事IDからコメントを削除する.
	 * 
	 * @param artcleId 記事ID
	 */
	public void deleteByArticleId(int articleId) {
		String sql = "delete from comments where article_id =:articleId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("articleId", articleId);
		template.update(sql, param);
	}

	
}
