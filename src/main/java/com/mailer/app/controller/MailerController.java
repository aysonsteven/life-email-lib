package com.mailer.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mailer.app.dto.MailDto;
import com.mailer.app.service.MailerService;

@RestController
@RequestMapping("/mailer")
public class MailerController {

	@Autowired
	private MailerService mailService;
	
	
	@PostMapping
	public void sendMail(@RequestBody MailDto mail, BindingResult bindResult) {
		mailService.sendMail(mail, bindResult);
	}
}
