package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Service.UserInfoService;
import com.model.UserInfo;

@RestController
public class RestUserController {
	
	@Autowired
	UserInfoService serv;

	@PostMapping("/saveUser")
	public UserInfo home(UserInfo user) {
		
		serv.save(user);
		return user;
		
	}
	
	@GetMapping("/hii")
	public String Hii() {
		return "Hiii";
		
		
	}

	
	

}
