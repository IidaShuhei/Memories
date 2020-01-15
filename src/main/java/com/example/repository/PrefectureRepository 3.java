package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;

/**
 * 各都道府県の記事を検索する.
 * 
 * @author iidashuhei
 *
 */
@Controller
@RequestMapping("")
public class PrefectureRepository {

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
	 * 北海道から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findHokkaido(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '北海道' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 青森から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findAomori(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '青森' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 岩手から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findIwate(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '岩手' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 宮城から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findMiyagi(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '宮城' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 秋田から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findAkita(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '秋田' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 山形から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findYamagata(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '山形' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 福島から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findFukushima(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '福島' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 茨城から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findIbaraki(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '茨城' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 栃木から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findTochigi(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '栃木' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 群馬から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findGunma(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '群馬' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 埼玉から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findSaitama(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '埼玉' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 千葉から記事を検索をする.
	 * 
	 * @return　検索結果
	 */
	public List<Article> findChiba(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '千葉' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 東京から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findTokyo(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '東京' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 神奈川から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findKanagawa(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '神奈川' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 新潟から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findNigata(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '新潟' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 富山から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findToyama(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '富山' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 石川から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findIshikawa(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '石川' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 福井から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findFukui(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '福井' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 山梨から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findYamanashi(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '山梨' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 長野から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findNagano(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '長野' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 岐阜から記事を検索をする.
	 * 
	 * @return　検索結果
	 */
	public List<Article> findGihu(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '岐阜' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 静岡から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findShizuoka(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '静岡' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 愛知から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findAichi(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '愛知' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 三重から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findMie(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '三重' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 滋賀から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findShiga(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '滋賀' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 京都から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findKyoto(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '京都' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 大阪から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findOsaka(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '大阪' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 兵庫から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findHyogo(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '兵庫' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 奈良から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findNara(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '奈良' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 和歌山から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findWakayama(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '和歌山' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 鳥取から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findTottori(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '鳥取' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 島根から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findShimane(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '島根' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 岡山から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findOkayama(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '岡山' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 広島から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findHiroshima(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '広島' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 山口から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findYamaguchi(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '山口' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 徳島から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findTokushima(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '徳島' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 香川から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findKagawa(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '香川' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 愛媛から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findEhime(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '愛媛' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 高知から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findKochi(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '高知' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 福岡から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findFukuoka(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '福岡' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 佐賀から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findSaga(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '佐賀' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 長崎から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findNagasaki(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '長崎' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 熊本から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findKumamoto(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '熊本' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 大分から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findOita(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '大分' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 宮崎から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findMiyazaki(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '宮崎' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 鹿児島から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findKagoshima(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '鹿児島' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
	/**
	 * 沖縄から記事を検索をする.
	 * 
	 * @return 検索結果
	 */
	public List<Article> findOkinawa(){
		String sql = "select id,title,name,prefecture,content,post_date,image_path from articles where prefecture = '沖縄' order by id";
		return template.query(sql,ARTICLE_ROW_MAPPER);
	}
}
