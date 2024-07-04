package com.boot.jpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Wakeup {

	@GetMapping("/wakeup")
	public String wakeup() {
		return "OK";
	}
}