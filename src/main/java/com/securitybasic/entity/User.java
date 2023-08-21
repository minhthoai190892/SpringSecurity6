package com.securitybasic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "username",nullable = false)
	private String userName;
	@Column(name = "password",nullable = false)
	private String password;
	@Column(name = "enabled",nullable = false)
	private int enabled;
}
