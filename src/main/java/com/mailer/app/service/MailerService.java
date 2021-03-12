package com.mailer.app.service;

import org.springframework.validation.BindingResult;

import com.mailer.app.dto.MailDto;

public interface MailerService {

	public void sendMail(MailDto mail, BindingResult biindResult);
	
}
