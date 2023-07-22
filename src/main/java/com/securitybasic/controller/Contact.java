package com.securitybasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Contact {
@GetMapping("/contac")
public String saveContactInquiryDetails() {
	return "Inquiry details are saved to the DB";
}
}
