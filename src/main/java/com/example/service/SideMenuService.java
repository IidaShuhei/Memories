package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Review;
import com.example.form.ContactForm;
import com.example.form.SortForm;
import com.example.repository.SideMenuRepository;

/**
 * サイドメニューを管理するサービス.
 * 
 * @author iidashuhei
 *
 */
@Service
@Transactional
public class SideMenuService {
	
	@Autowired
	private MailSender mailSender;

	@Autowired
	private SideMenuRepository repository;
	
	/**
	 * お問い合わせメールを送信する.
	 * 
	 * @param contactForm 問い合わせフォーム
	 */
	public void sendMail(ContactForm contactForm) {
		SimpleMailMessage msg = new SimpleMailMessage();
		String body = "お名前: " + contactForm.getName() + "\n" + 
                "メールアドレス: " + contactForm.getContactEmail() + "\n" + 
                "メッセージ: \n" + contactForm.getContactMessage();
        msg.setFrom(contactForm.getContactEmail());
        msg.setTo("rakus.yahoo@gmail.com"); // 適宜変更してください
        msg.setSubject("お問い合わせがありました");
        msg.setText("お問い合わせは下記の通りです。\n\n---------------------------\n" + body + "\n---------------------------");
        mailSender.send(msg);
	}

	/**
	 * レビュー一覧を表示する.
	 * 
	 * @return レビュー一覧
	 */
	public List<Review> showReviewList() {
		return repository.findAll();
	}

	/**
	 * レビューを挿入する.
	 * 
	 * @param review レビュー
	 */
	public void insert(Review review) {
		repository.insert(review);
	}

	
	/**
	 * 評価が高い順、低い順で並び替える.
	 * 
	 * @param sortForm ソートフォーム
	 * @return 評価が高い順、低い順
	 */
	public List<Review> findByStar(SortForm sortForm) {
		String sort = sortForm.getSort();
		
		System.err.println(sort);
		
		List<Review> reviewList = null;
		if ("high".equals(sort)) {
			reviewList = repository.findByHighStar();
			
			System.out.println(reviewList);
			
		} else if("low".equals(sort)){
			reviewList = repository.findByLowStar();
		}
		return reviewList;
	}
}