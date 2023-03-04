package com.schedulingMail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchduledMail {

	@Autowired
	JavaMailSender mail;
	

	@Value("${spring.mail.username}")
	private String sender;
	
	String recipient="sriman799@gmail.com" ;
	//@Scheduled(fixedRate = 10000)
	@Scheduled(cron = "0 0 0 1 1 *")
	public String scheduledMail() {
		
		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setTo(recipient);
		msg.setFrom(sender);
		msg.setSubject("Good AfterNoon");
		msg.setText("Hi bro this is Scheduled Mail For u...");
		mail.send(msg);
		System.out.println("Mail Sent succesfully....!");
		return "Mail sent SucessFully...!";
		
		
	}
	
}
