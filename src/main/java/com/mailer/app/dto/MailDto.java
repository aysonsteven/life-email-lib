package com.mailer.app.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MailDto {
	
	@NotNull
	private String name;
	
	@NotNull
	@Email
	private String receiver;
	
	@NotNull
	@Min(10)
	private String message;
	
	private String subject;

	public String getName() {
		return name;
	}
	
	

	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public void setName(String name) {
		this.name = name;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
	
}
