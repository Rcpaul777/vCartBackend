package com.lnt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	@Autowired
	MailSender mailSender;
	
	public void sendEmailForNewRegistration(String email,String text,String subject) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("onlineshoppingprojectgladiator@gmail.com");
		message.setTo("omkarwaikar12@gmail.com");
		message.setSubject(subject);
		message.setText(text);
		mailSender.send(message);

	}

}
