package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskController {

	@Autowired
	private MailSender mailsender;

	@Scheduled(cron = "0 0 6 * * 1-5")
	public void task() {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("rakus.yahoo@gmail.com");
		msg.setTo("tennis.yahoo@icloud.com");
		msg.setSubject("こんにちは");
		msg.setText("今日も一日頑張りましょう。");
		
		this.mailsender.send(msg);
	}
}
