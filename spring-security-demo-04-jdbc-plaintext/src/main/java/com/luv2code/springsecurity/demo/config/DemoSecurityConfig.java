package com.luv2code.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private DataSource securityDataSource;
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		//add our users for in memory authentication
		
		/*
		 * UserBuilder Users = User.withDefaultPasswordEncoder();
		 * auth.inMemoryAuthentication()
		 * .withUser(Users.username("john").password("test123").roles("EMPLOYEE"))
		 * .withUser(Users.username("mary").password("test123").roles("MANAGER"))
		 * .withUser(Users.username("susan").password("test123").roles("ADMIN")); }
		 */
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
	}
		
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.anyRequest().authenticated().and().formLogin()
		.loginPage("/showMyLoginPage")
		.loginProcessingUrl("/authenticateTheUser")
		.permitAll()
		.and().logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/access-denied");
	}

	
	
}
