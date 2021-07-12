package com.springsecurity.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {
	
	// APIs information
	//account --> secured
	//balance --> secured
	//update  --> not secured
	//main    --> not secured
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/*Default configuration which check all the request*/
		/*
		http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
		http.formLogin();
		http.httpBasic();
		  */
		
		/*
		  Custom configuration as per requirement
		 */
		
		http.authorizeRequests(
				(requests) -> requests.antMatchers("/account").authenticated()
									  .antMatchers("/balance").authenticated()
									  .antMatchers("/update").permitAll()
									  .antMatchers("/main").permitAll()			
				);
		http.formLogin();
		http.httpBasic();
	}
		// permit all APIs
		/*
		http.authorizeRequests((requests) -> requests.anyRequest().permitAll());
		http.formLogin();
		http.httpBasic();
		*/
		
		//deny all
		/*
		http.authorizeRequests((requests) -> requests.anyRequest().denyAll());
		http.formLogin();
		http.httpBasic();
		*/
		
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser("admin").password("1234").authorities("admin")
		.and().withUser("user").password("1234").authorities("read")
		.and().passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	*/
	
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { // TODO Auto-generated method stub InMemoryUserDetailsManager
	 * userDetailService = new InMemoryUserDetailsManager(); UserDetails
	 * user=User.withUsername("admin").password("1234").authorities("admin").build()
	 * ; UserDetails
	 * user1=User.withUsername("user").password("1234").authorities("admin").build()
	 * ; userDetailService.createUser(user); userDetailService.createUser(user1);
	 * auth.userDetailsService(userDetailService);
	 * 
	 * }
	 */

	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource ) {
		return new JdbcUserDetailsManager(dataSource);
	}
	
	
	@Bean
	public PasswordEncoder getObject()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	

		
}
	
