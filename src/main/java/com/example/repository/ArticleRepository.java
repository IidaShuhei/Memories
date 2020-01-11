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
	
//	private static final ResultSetExtractor<List<Article>> COMMENT_RESULT_SET_EXTRACTOR = (rs) -> {
//	
//		List<Article> articleList = new ArrayList<>();
//		int preId = 0;
//		List<Comment> commentList = null;
//		
//		while (rs.next()) {
//			int nowId = rs.getInt("id");
//			
//			if(nowId != preId) {
//				Article article = new Article();
//				article.setId(rs.getInt("id"));
//				article.setTitle(rs.getString("title"));
//				article.setName(rs.getString("name"));
//				article.setPrefecture(rs.getString("prefecture"));
//				article.setContent(rs.getString("content"));
//				article.setPostDate(rs.getDate("post_date"));
//				article.setImagePath(rs.getString("image_path"));
//				
//				commentList = new ArrayList<>();
//				article.setCommentList(commentList);
//				articleList.add(article);
//			}
//			
//			if(rs.getInt("com_id") != 0) {
//				Comment comment = new Comment();
//				comment.setId(rs.getInt("com_id"));
//				comment.setName(rs.getString("com_name"));
//				comment.setContent(rs.getString("com_content"));
//				comment.setArticleId(rs.getInt("article_id"));
//				commentList.add(comment);
//			}
//			preId = nowId;
//		}
//		return articleList;
//	};

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
//	public List<Article> findAll(){
//		String sql = "select articles.id,articles.title,articles.name,articles.prefecture,articles.content,articles.post_date,articles.image_path,"
//				+ " comments.id as com_id,comments.name as com_name,comments.content as com_content,comments.article_id from articles"
//				+ " left outer join comments on articles.id = comments.article_id order by id desc";
//		return template.query(sql, COMMENT_RESULT_SET_EXTRACTOR);
//	}
	
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
	 * 記事情報を登録する.
	 * 
	 * @param article　
	 */
	public void insert(Article article) {
		String sql = "insert into articles(title,name,prefecture,content,post_date,image_path,trip_start_date,trip_end_date)values(:title,:name,:prefecture,:content,:postDate,:imagePath,:tripStartDate,:tripEndDate)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(article);
		template.update(sql, param);
	
	}
	
	/**
	 * 記事を更新する.
	 * 
	 * @param article　記事
	 */
	public void update(Article article) {
		String sql = "update articles set title=:title,name=:name,prefecture=:prefecture,content=:content,post_date=:postDate,image_path=:imagePath where id=:id";
		SqlParameterSource param = new BeanPropertySqlParameterSource(article);
		template.update(sql, param);
	}
	
	/**
	 * 記事を削除する.
	 * 
	 * @param id ID
	 */
	public void delete(Integer id) {
		String sql = "delete from articles where id=:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		template.update(sql, param);
	}
}