package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Review;

/**
 * サイドメニューを管理するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Repository
public class SideMenuRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Review>REVIEW_ROW_MAPPER = (rs,i) -> {
	
		Review review = new Review();
		review.setId(rs.getInt("id"));
		review.setStar(rs.getInt("star"));
		review.setReviewTitle(rs.getString("review_title"));
		review.setMessage(rs.getString("message"));
		return review;
	};
	
	/**
	 * レビュー一覧を検索する.
	 * 
	 * @return レビュー一覧
	 */
	public List<Review> findAll(){
		String sql = "select id,star,review_title,message from reviews order by star";
		return template.query(sql, REVIEW_ROW_MAPPER);
	}
	
	/**
	 * レビューを挿入する.
	 * 
	 * @param review レビュー
	 */
	public void insert(Review review) {
		String sql = "insert into reviews(star,review_title,message)values(:star,:reviewTitle,:message)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(review);
		template.update(sql, param);
	}
}
