package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

@Value("${envName}")
	private String env;

	
	
	@GetMapping("/getEnv")
	public String env() {
		return env;

	}

}
