package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.UserInfo;
import com.userService.UserInfoService;
import com.userService.UserInfoServiceImpl;

@RestController
public class UserController {
	
	
	
	@Autowired
	UserInfoService serv;

	@GetMapping("/home")
	public UserInfo home() {
		return serv.findByUserName("shan");
	}

	
	@GetMapping("/login/home")
	public String loginHome() {
		return "After login common for all users Home";
	}
	
	@GetMapping("/login/user")
	public String loginUser() {
		return "After login Only for User";
	}
	
	
	@GetMapping("/login/admin")
	public String loginAdmin() {
		return "After login Only for Admin";
	}
	
	@GetMapping("/login/welcome")
	public String Welcome() {
		return "WelCome";
	}
	
	
	@GetMapping("/AccessDeied")
	public String AccessDeied() {
		return "AccessDeied  403";
	}
	
	
	
}
