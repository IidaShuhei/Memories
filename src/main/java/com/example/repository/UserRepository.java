package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

/**
 * ユーザーを登録するリポジトリ.
 * 
 * @author iidashuhei
 *
 */
@Repository
public class UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	public static final RowMapper<User> USER_ROW_MAPPER = (rs, i) -> {

		User user = new User();
		user.setUserId(rs.getInt("user_id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setZipcode(rs.getString("zipcode"));
		user.setAddress(rs.getString("address"));
		user.setTelephone(rs.getString("telephone"));
		user.setNickName(rs.getString("nick_name"));
		user.setImage(rs.getString("image"));
		return user;
	};
	public static final RowMapper<User> USER1_ROW_MAPPER = (rs, i) -> {
		User user = new User();
		user.setImage(rs.getString("image"));
		return user;
	};

	/**
	 * ユーザーを登録する.
	 * 
	 * @param user ユーザー
	 */
	public void insert(User user) {
		String sql = "insert into users(name,email,password,zipcode,address,telephone,nick_name,image)values(:name,:email,:password,:zipcode,:address,:telephone,:nickName,:image)";
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		template.update(sql, param);
	}

	/**
	 * メールアドレスでユーザー情報を取得するメソッド.
	 * 
	 * @param email メールアドレス
	 * @return ユーザー情報 / 存在しなければnullを返す
	 */
	public User findByEmail(String email) {
		String sql = "SELECT user_id, name, email, password, zipcode, address, telephone, nick_name, image from users WHERE email = :email";
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email);
		List<User> userList = template.query(sql, param, USER_ROW_MAPPER);
		if(userList.size() == 0) {
			return null;
		}
		return userList.get(0);
	}
	
	/**
	 * パスワードからユーザー情報をとってくる.
	 * 
	 * @param password パスワード
	 * @return　ユーザー情報
	 */
	public User findByPassword(String password) {
		String sql = "select id,name,email,password,zipcode,address,telephone,nick_name,image from users where password = :password";
		SqlParameterSource param = new MapSqlParameterSource().addValue("password", password);
		User user = template.queryForObject(sql, param, USER_ROW_MAPPER);
		if (user==null) {
			return null;
		}else {
			return user;
		}
	}
	
	/**
	 * ユーザー情報を更新する.
	 * 
	 * @param nickName ニックネーム
	 * @param image 画像
	 */
	public void update(String nickName, String image) {
		String sql = "update users set nick_name =:nickName, image =:image";
		SqlParameterSource param = new MapSqlParameterSource().addValue("nickName", nickName).addValue("image", image);
		template.update(sql, param);
	}
	
	/**
	 * idから画像を探してくる.
	 * 
	 * @param id Id
	 * @return ユーザー情報
	 */
	public User findImageById(Integer id) {
		String sql = "select image from users where user_id =:id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		return template.queryForObject(sql, param, USER1_ROW_MAPPER);
	}
}