package com.example.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class LoginForm {
	
	@Email(message="Eメールの形式が不正です")
	@NotBlank(message="メールアドレスを入力してください")
	private String email;
	
	@NotBlank(message="パスワードを入力してください")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}
