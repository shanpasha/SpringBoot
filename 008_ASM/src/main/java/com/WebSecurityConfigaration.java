package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.Authentiction.AsmUserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigaration {
	
	
	@Bean
	public BCryptPasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public SecurityFilterChain securitychain(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
				.antMatchers("/register","/regi","/home").permitAll()
				.antMatchers("/getAllUsers","/getAllroles").hasAuthority("User")
				.anyRequest().authenticated().and().formLogin().loginPage("/login")
				.permitAll().defaultSuccessUrl("/home", true).and().logout().permitAll();
		return http.build();
}		
	

	

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http,AsmUserDetailsServiceImpl userDeatils,BCryptPasswordEncoder encode) throws Exception {
		
		
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDeatils).passwordEncoder(encode).and().build();
		
	}

}
