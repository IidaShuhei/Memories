package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
		return user;
	};

	/**
	 * ユーザーを登録する.
	 * 
	 * @param user ユーザー
	 */
	public void insert(User user) {
		String sql = "insert into users(name,email,password,zipcode,address,telephone)values(:name,:email,:password,:zipcode,:address,:telephone)";
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
		String sql = "SELECT user_id, name, email, password zipcode, address, telephone from users WHERE email = :email";
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email);
		try {
			return template.queryForObject(sql, param, USER_ROW_MAPPER);
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}
}