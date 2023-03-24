package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mailUtill.MailUtil;

@RestController
public class MailController {
	
	@Autowired
	MailUtil mail;
	
	@GetMapping("/sendEmail")
	public String sendEmail(@RequestParam("email") String email) {
		
		return mail.sendSimpleMail(email);
		
		
		
	}

}
