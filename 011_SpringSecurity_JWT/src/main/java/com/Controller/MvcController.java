 package com.Controller;

import org.springframework.web.bind.annotation.GetMapping;
@org.springframework.stereotype.Controller
public class MvcController {
	

	@GetMapping("/home")
	public String home() {
		return "Before login we can access this page";
		
	}

	
	@GetMapping("/welcome")
	public String Welcome() {
		return "After loggin in Common welcome page";
		
	}
	
	
	@GetMapping("/user")
	public String User() {
		return "this page access user only";
	}
	
	
	@GetMapping("/admin")
	public String Admin() {
		return "this page access Admin only";
	}
	
	@GetMapping("/accessDenied")
	public String AccessDe() {
		return "U dont have permission to Access this Page  accessDenied 403";
	}
	
	@GetMapping("/common")
	public String Common() {
		return "After login anyone Can Access";
	}

}
