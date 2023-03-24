package com.mailUtill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Component
public class MailUtil {
	
	@Autowired
	JavaMailSender mail;
	
	@Value("/${spring.mail.username}")
	private String sender;
	
	public String sendSimpleMail(String recipient) {
		
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setFrom(sender);
		msg.setTo(recipient);
		msg.setSubject("SpringBoot Mail");
		msg.setText("Hi iam shan this From SringBoot EmailService");
		
		mail.send(msg);
	
		
		return "Msg Sent Sucessfully...!";
		

	

		
		
	}
		
	}
	



