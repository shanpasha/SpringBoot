package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.Authentication.MyUserDetailsService;

// we have to configure to beans in this Class
//1.SecurityFilterChain
//2.AuthenticationManager
//then this class sholud be annotated with @Configuration and @enableWebSecurity


@EnableWebSecurity
@Configuration
public class WebSecurity {

	
	
	@Bean
	public SecurityFilterChain  filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests().antMatchers("/home").permitAll()
		.antMatchers("/user").hasAuthority("User").
		antMatchers("/admin").hasAuthority("Admin")
		.antMatchers("/common").hasAnyAuthority("Admin","User")
		.anyRequest().authenticated().and().formLogin()
		.defaultSuccessUrl("/welcome",true).
		and().exceptionHandling().accessDeniedPage("/accessDenied")
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		return http.build();
		
		
		
	}
	
	@Bean
	public AuthenticationManager manager( HttpSecurity http,BCryptPasswordEncoder encode, MyUserDetailsService user) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(user)
				.passwordEncoder(encode).and().build();
		
		
	}
	
	
@Bean
BCryptPasswordEncoder encode() {
	return new BCryptPasswordEncoder();
	
	
}
	
}
