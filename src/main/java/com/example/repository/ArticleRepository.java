package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Article;

/**
 * 記事を操作するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Repository
public class ArticleRepository {
	
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
		return article;
	};
	/**
	 * 記事を全件検索する.
	 * 
	 * @return 全記事
	 */
	public List<Article> findAll(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles order by id";
		return template.query(sql, ARTICLE_ROW_MAPPER);
	}
	/**
	 * タイトルから曖昧検索をする.
	 * 
	 * @param name 名前
	 * @return 曖昧検索結果
	 */
	public List<Article> findByTitle(String title){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where title Ilike :title";
		SqlParameterSource param = new MapSqlParameterSource().addValue("title",'%' + title + '%');
		return template.query(sql, param, ARTICLE_ROW_MAPPER);
	}
	/**
	 * 投稿者名から曖昧検索をする.
	 * 
	 * @param name 名前
	 * @return 曖昧検索結果
	 */
	public List<Article> findByName(String name){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where name Ilike :name";
		SqlParameterSource param = new MapSqlParameterSource().addValue("name",'%' + name + '%');
		return template.query(sql, param, ARTICLE_ROW_MAPPER);
	}
	/**
	 * 内容から曖昧検索をする.
	 * 
	 * @param name 名前
	 * @return 曖昧検索結果
	 */
	public List<Article> findByContent(String content){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where content Ilike :content";
		SqlParameterSource param = new MapSqlParameterSource().addValue("content",'%' + content + '%');
		return template.query(sql, param, ARTICLE_ROW_MAPPER);
	}
	/**
	 * 記事の詳細を表示する.
	 * 
	 * @param id ID
	 * @return 記事詳細
	 */
	public Article load(Integer id) {

		String sql = "select id,title,name,prefecture,content,image_path,post_date from articles where id =:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		return template.queryForObject(sql, param, ARTICLE_ROW_MAPPER);
	}
	
	/**
	 * 記事情報を登録する
	 * @param article　
	 */
	public void insert(Article article) {
		String sql = "insert into articles(title,name,prefecture,content,post_date,image_path)values(:title,:name,:prefecture,:content,:postDate,:imagePath)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(article);
		template.update(sql, param);
				
	}
	
	
}
