package com.boot.jpa;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Scheduler {
	
	@Scheduled(fixedRate = 600000)
	public void cronJob() {
//		System.out.println("CRON running");
		RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8080/wakeup", String.class);
		String response = restTemplate.getForObject("https://springboot-sql-api.onrender.com/wakeup", String.class);
        System.out.println(response);
        
	}
	
}