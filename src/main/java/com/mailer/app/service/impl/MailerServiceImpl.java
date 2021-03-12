package com.mailer.app.service.impl;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.mailer.app.config.MailerConfig;
import com.mailer.app.dto.MailDto;
import com.mailer.app.service.MailerService;

@Service
public class MailerServiceImpl implements MailerService {

	@Autowired
	private MailerConfig config;
	
	@Override
	public void sendMail(MailDto mail, BindingResult bindResult) {
		
		if(bindResult.hasErrors()) {
			throw new ValidationException("Invalid");
		}
		
		//build mail sender config
		JavaMailSenderImpl mailSender = buildMailSender();
		
		//build email instance
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom(mail.getSender());
		msg.setTo(mail.getReceiver());
		msg.setSubject(mail.getSubject());
		msg.setText(mail.getMessage());
		
		mailSender.send(msg);
	}
	
	private JavaMailSenderImpl buildMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(this.config.getHost());
		mailSender.setPort(this.config.getPort());
		mailSender.setUsername(this.config.getUsername());
		mailSender.setPassword(this.config.getPassword());
		return mailSender;
	}


}
