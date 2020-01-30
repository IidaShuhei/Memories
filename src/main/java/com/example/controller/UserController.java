package com.example.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.LoginUser;
import com.example.domain.User;
import com.example.form.UserForm;
import com.example.service.UserService;

/**
 * ユーザー情報を管理するコントローラー.
 * 
 * @author iidashuhei
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	/**
	 * ユーザー情報を更新する.
	 * 
	 * @param userForm ユーザーフォーム
	 * @return　記事一覧
	 * @throws IOException
	 */
	@RequestMapping("/update")
	public String update(UserForm userForm,@AuthenticationPrincipal LoginUser loginUser) throws IOException {
		
		User user = new User();
		
		user.setNickName(userForm.getNickName());
		
		byte[] encoded = Base64.getEncoder().encode(userForm.getImage().getBytes());
		Charset charset = StandardCharsets.UTF_8;

		String base64 = new String(encoded, charset);
		String fileExtension = userForm.getImage().getOriginalFilename()
				.substring(userForm.getImage().getOriginalFilename().length() - 3);
		StringBuilder base64image = new StringBuilder();
		if ("jpg".equals(fileExtension)) {
			base64image.append("data:image/jpeg;base64,");
		}
		if ("png".equals(fileExtension)) {
			base64image.append("data:image/png;base64,");
		}
		base64image.append(base64);
		user.setImage(base64image.toString());
		
		service.update(user.getNickName(),user.getImage());
		
		loginUser.getUser().setImage(base64.toString());
		loginUser.getUser().setNickName(userForm.getNickName());
		return "redirect:/";
	}
}
