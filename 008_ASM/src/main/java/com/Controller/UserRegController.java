package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.UserInfo;
import com.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserRegController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/register")
	public String Registartion(UserInfo user) {
		
		return "RegistrationForm";
	}
	
	@PostMapping("/regi")
	public String RegistartionUser(UserInfo user) {
		log.info("PostMethod Working************");
		 service.registration(user);
		 log.info("PostMethod After Working************{}");
		 return "redirect:/login";
		
		
		
		
		
	}

}
