package com.securitybasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.securitybasic.entity.Customer;
import com.securitybasic.repository.CustomerRepository;

@RestController
public class LoginRestController {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@RequestBody Customer customer){
		Customer saveCustomer = null;
		ResponseEntity responseEntity = null;
		try {
			String hashPwd = passwordEncoder.encode(customer.getPwd());
			customer.setPwd(hashPwd);
			saveCustomer =customerRepository.save(customer);
			if (saveCustomer.getId()>0) {
				responseEntity=ResponseEntity.status(HttpStatus.CREATED).body("Given user details are successfully registered");
			}
		} catch (Exception e) {
			// TODO: handle exception
			responseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An exception occured due to "+e.getMessage());
		}
		return responseEntity;
		
	}
}
