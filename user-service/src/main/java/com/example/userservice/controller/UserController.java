package com.example.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.vo.Greeting;

@RestController
@RequestMapping("/")
public class UserController {
	private Environment env;
	@Autowired
	public UserController(Environment env) {
		this.env = env;
	}

	@Autowired
	private Greeting greeting;

	@GetMapping("/health-check")
	public String status() {
		return "It's working in user service.";
	}

	@GetMapping("/welcome")
	public String welcome() {
		// return env.getProperty("greeting.message");
		return greeting.getMessage();
	}
}
