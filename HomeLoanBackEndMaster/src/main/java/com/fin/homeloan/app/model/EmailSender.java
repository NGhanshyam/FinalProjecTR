package com.fin.homeloan.app.model;

import lombok.Data;

@Data
public class EmailSender {
	private String toEmail;
	private String fromEmail;
	private String subject;
	private String textMessage;
}
