package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Article;
import com.example.domain.Good;

@Repository
public class GoodRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private static final RowMapper<Article>ARTICLE_ROW_MAPPER = (rs,i) -> {
		
		Article article = new Article();
		article.setId(rs.getInt("id"));
		article.setTitle(rs.getString("title"));
		article.setName(rs.getString("name"));
		article.setPrefecture(rs.getString("prefecture"));
		article.setContent(rs.getString("content"));
		article.setPostDate(rs.getDate("post_date"));
		article.setImagePath(rs.getString("image_path"));
		article.setTripStartDate(rs.getDate("trip_start_date"));
		article.setTripEndDate(rs.getDate("trip_end_date"));
		article.setTransportation(rs.getString("transportation"));
		article.setFare(rs.getInt("fare"));
		article.setHotelName(rs.getString("hotel_name"));
		article.setHotelFee(rs.getInt("hotel_fee"));
		article.setMealFee(rs.getInt("meal_fee"));
		article.setOtherAmount(rs.getInt("other_amount"));
		article.setTotalFee(rs.getInt("total_fee"));
		
		return article;
	};
	
	private static final RowMapper<Good> GOOD_ROW_MAPPER = (rs,i) -> {
		Good good = new Good();
		good.setId(rs.getInt("id"));
		good.setUserId(rs.getInt("user_id"));
		good.setArticleId(rs.getInt("article_id"));
		return good;
	};
	
	/**
	 * いいねを追加する.
	 * 
	 * @param userId ユーザーID
	 * @param goodId グッドID
	 */
	public void insert(Integer userId,Integer articleId) {
		String sql = "INSERT INTO goods (user_id,article_id) VALUES (:userId,:articleId)";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId",userId).addValue("articleId", articleId);
		template.update(sql, param);
	}
	
	/**
	 * いいねを削除する.
	 * 
	 * @param userId ユーザーID
	 * @param goodId グッドID
	 */
	public void delete(Integer userId,Integer articleId) {
		String sql = "DELETE FROM goods WHERE user_id = :userId AND article_id = :articleId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId",userId).addValue("articleId", articleId);
		template.update(sql, param);
	}
	
	/**
	 * ユーザーIDから記事を検索する.
	 * 
	 * @param userId ユーザーID
	 * @return 記事一覧
	 */
	public List<Article> findByUserId(Integer userId){
		String sql = "SELECT a.id AS id,a.title AS title,a.name AS name,a.prefecture AS prefecture,a.content AS content,a.post_date AS post_date,"
				+ "a.image_path AS image_path,a.trip_start_date AS trip_start_date,a.trip_end_date AS trip_end_date,a.transportation AS transportation,"
				+ "a.fare AS fare,a.hotel_name AS hotel_name,a.hotel_fee AS hotel_fee,a.meal_fee AS meal_fee,a.other_amount AS other_amount,a.total_fee AS total_fee "
				+ "FROM articles AS a JOIN goods AS g ON a.id = g.article_id WHERE g.user_id = :userId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId", userId);
		return template.query(sql, param,ARTICLE_ROW_MAPPER);
	}
	
	/**
	 * ユーザーIDと記事IDからいいねを探してくる.
	 * 
	 * @param userId ユーザーID
	 * @param goodId グッドID
	 * @return グッドリスト
	 */
	public List<Good> findByUserIdAndArticleId(Integer userId,Integer articleId) {
		String sql = "SELECT id,user_id,article_id FROM goods WHERE user_id = :userId AND article_id = :articleId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId", userId).addValue("articleId", articleId);
		return template.query(sql, param,GOOD_ROW_MAPPER);
	}
	
	/**
	 * いいね数を求める.
	 * 
	 * @param articleId 記事ID
	 * @return いいね数
	 */
	public Integer good(Integer articleId) {
		String sql = "select count(*) from goods where article_id =:articleId";
		SqlParameterSource param = new MapSqlParameterSource().addValue("articleId", articleId);
		return template.queryForObject(sql, param,Integer.class);
	}
}