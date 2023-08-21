package com.securitybasic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "authorities")
public class Authorities {
	@Id
	@Column(nullable = false)
	private Integer id;
	@Column(nullable = false)
	private String  username;
	@Column(nullable = false)
	private String authority;
}
