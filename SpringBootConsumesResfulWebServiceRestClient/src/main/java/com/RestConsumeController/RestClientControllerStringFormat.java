package com.RestConsumeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestClientControllerStringFormat {
	@Autowired
	RestTemplate restTemplate;
	

	@GetMapping("/Emp/getAll")
	public String callEmpService(){
		
		return restTemplate.getForObject("http://localhost:9090/findAll",String.class);
		
		
	}

}
