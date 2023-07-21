package com.securitybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRestController {
	@GetMapping("/")
	public String show() {
		return "Test Rest Controller Security 6";
	}
}
