package com.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedules {
	
	
@Scheduled(fixedRate = 5000)
	public void String() {
		
		System.out.println("My schedules..");
	}

}
