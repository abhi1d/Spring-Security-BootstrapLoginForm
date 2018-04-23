package com.luv2code.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to our security data source
	
	@Autowired
	private DataSource securityDataSource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*// add our users for in memory authentication
		
		 UserBuilder users = User.withDefaultPasswordEncoder();
	
		 auth.inMemoryAuthentication()
		     .withUser(users.username("abhi").password("test123").roles("EMPLOYEE"))
		     .withUser(users.username("marry").password("test123").roles("MANAGER","EMPLOYEE"))
		     .withUser(users.username("saurabh").password("test123").roles("ADMIN","EMPLOYEE"));
*/	
	 auth.jdbcAuthentication().dataSource(securityDataSource);	
	
	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/leaders/**").hasRole("MANAGER")
			.antMatchers("/systems/**").hasRole("ADMIN")
		    .and()
		    .formLogin()
		    .loginPage("/showMyLoginPage")
		    .loginProcessingUrl("/authenticateTheUser")
		    .permitAll()
		    .and()
		    .logout()
		    .permitAll()
		    .and()
		    .exceptionHandling().accessDeniedPage("/access-denied");
		
	}
	
	  
	

}
