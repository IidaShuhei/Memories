package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Good;
import com.example.domain.User;
import com.example.repository.GoodRepository;
import com.example.service.RegisterUserService;

/**
 * JSON形式で受け取るコントローラー.
 * 
 * @author iidashuhei
 *
 */
@RestController
public class JSONController {

	@Autowired
	private RegisterUserService service;
	
	@Autowired
	private GoodRepository goodRepository;

	/**
	 * メールを返す.
	 * 
	 * @param email メール
	 * @return メールアドレス
	 */
	@RequestMapping("/judge")
	public User emailReturn(String email) {
		User user = service.findByEmail(email);
		if(user == null) {
			user = new User();
		}
		return user;
	}
	
	/**
	 * いいねを返す.
	 * 
	 * @param good グッド
	 * @return グッドを返す
	 */
	@RequestMapping("/good")
	public List<Good> update(Integer userId,Integer id,Model model) {
		List<Good> goodList = goodRepository.findByUserIdAndArticleId(userId, id);
		if(goodList.size() == 0) {
			goodRepository.insert(userId, id);
		} else {
			goodRepository.delete(userId, id);
		}
		return goodList;
	}
	
	/**
	 * いいね数を返す.
	 * 
	 * @param articleId 記事Id
	 * @return いいね数
	 */
	@RequestMapping("/countGood")
	public Integer good(Integer articleId, Model model) {
		Integer good =  goodRepository.good(articleId);
		if(good == null) {
			good = 0;
		}
		model.addAttribute("good", good);
		return good;
	}
}
