package com.mailUtill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;



@Component
public class MailUtil {
	
	@Autowired
	JavaMailSender mail;
	
	 @Value("/${spring.mail.username}")
	private String sender;
	
	public String sendSimpleMail(String recipient) {
		try {
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setFrom(sender);
		msg.setTo(recipient);
		msg.setText("Hi iam shan this From SringBoot EmailService");
		msg.setSubject("SpringBoot Mail");
		
		System.out.println(mail);
//		mail.send(msg);
		mail.send(msg);
		
		return "Msg Sent Sucessfully...!";
		

	
} catch (Exception e) {
return "Error mail not sent";
}
		
		
	}
		
	}
	



