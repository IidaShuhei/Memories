package com.example.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.User;

@Repository
public class LoginRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	public final static RowMapper<User> LOGIN_ROW_MAPPER = (rs, i) -> {
		User user = new User();
		user.setUserId(rs.getInt("user_id"));
		user.setName(rs.getString("name"));
		user.setZipcode(rs.getString("zipcode"));
		user.setAddress(rs.getString("address"));
		user.setTelephone(rs.getString("telephone"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		return user;
	};
	
	/**
	 * メールアドレスとパスワードを検索リポジトリ
	 * @param email
	 * @param password
	 * @return　メールアドレスとパスワード
	 */
	public User findByemailAndPassword(String email,String password) {
		String sql = "select user_id,name,email,password,zipcode,address,telephone from users where email=:email and password=:password";
		SqlParameterSource param = new MapSqlParameterSource().addValue("email", email).addValue("password", password);
		try {
			User user = template.queryForObject(sql, param, LOGIN_ROW_MAPPER);
			return user;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
