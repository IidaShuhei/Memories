package com.example.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.LoginUser;
import com.example.domain.User;
import com.example.repository.LoginRepository;
import com.example.repository.UserRepository;

@Service
@Transactional
public class LoginService implements UserDetailsService{

	@Autowired
	private LoginRepository repository;

	@Autowired
	private UserRepository userRepository;

	/**
	 * メールとパスワードからユーザー情報を取得する.
	 * 
	 * @param email    メール
	 * @param password パスワード
	 * @return ユーザー情報
	 */
	public User login(String email, String password) {
		User user = repository.findByemailAndPassword(email, password);
		return user;
	}

	/**
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 *      loadUserByUsername(java.lang.String) DBから検索をし、ログイン情報を構成して返す。
	 */
	@Override
	public UserDetails loadUserByUsername(String mailAddress) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(mailAddress);
		if (user == null) {
			throw new UsernameNotFoundException("そのメールアドレスは登録されていません");
		}
		// 権限付与の例
		Collection<GrantedAuthority> authorityList = new ArrayList<>();
		authorityList.add(new SimpleGrantedAuthority("ROLE_USER")); // ユーザ権限付与
		return new LoginUser(user, authorityList);
	}
}