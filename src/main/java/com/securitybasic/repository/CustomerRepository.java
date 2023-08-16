package com.securitybasic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.securitybasic.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
List<Customer> findByEmail(String email);
}
