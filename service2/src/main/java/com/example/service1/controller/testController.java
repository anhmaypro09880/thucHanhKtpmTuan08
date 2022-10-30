package com.example.service1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class testController {
	@GetMapping("/")
	public String sayHello() {
		return "Hello from service 1";
	}

}
