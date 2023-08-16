package com.securitybasic.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
//	@Bean
//	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests().anyRequest().authenticated();
//		http.formLogin();
//		http.httpBasic();
//		return http.build();
//
//	}
//	@Bean
//	 InMemoryUserDetailsManager userDetailsManager() {
//		UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("123456").authorities("admin").build();
//		UserDetails user = User.withDefaultPasswordEncoder().username("admin").password("123456").authorities("read").build();
//		return new InMemoryUserDetailsManager(admin,user);
//	}
//	@Bean
//	public UserDetailsService users() {
//		// The builder will ensure the passwords are encoded before saving in memory
//		UserBuilder users = User.withDefaultPasswordEncoder();
//		UserDetails user = users
//			.username("user")
//			.password("password")
//			.roles("USER")
//			.build();
//		UserDetails admin = users
//			.username("admin")
//			.password("password")
//			.roles("USER", "ADMIN")
//			.build();
//		return new InMemoryUserDetailsManager(user, admin);
//	}
//	@Bean
//	public UserDetailsService detailsService(DataSource dataSource) {
//		return new JdbcUserDetailsManager(dataSource);
//	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(configurer -> configurer
				.requestMatchers("/myAccount/**","/myBalance/**","/myCards/**","/contact/**","/myLoan/**","/notices/**").permitAll()
				.anyRequest().authenticated())
		.formLogin(login -> login// hiển thị form login
						.permitAll())
				.logout(logout -> logout// logout
						.permitAll());

		return http.build();

	}
	
}
