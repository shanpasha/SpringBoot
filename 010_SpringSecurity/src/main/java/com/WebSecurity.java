package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//Step3

import com.userService.UserDetailsServiceImpl;
@Configuration
@EnableWebSecurity
public class WebSecurity {
	@Autowired
	UserDetailsServiceImpl userDetails;
	
	@Autowired
	BCryptPasswordEncoder bcrpt;
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http ) throws Exception {
		
		http.authorizeHttpRequests().antMatchers("/home").permitAll()
		.antMatchers("/login/home").authenticated()
		.antMatchers("/login/user").hasAuthority("User")
		.antMatchers("/login/admin").hasAuthority("Admin")
		.antMatchers("/login/home").hasAnyAuthority("Admin","User").anyRequest().authenticated().and()
		.formLogin().defaultSuccessUrl("/login/welcome",true)
		.and().exceptionHandling().accessDeniedPage("/AccessDeied")
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
		return http.build();
		
	}

	@Bean
	public AuthenticationManager authManager(HttpSecurity http,BCryptPasswordEncoder encode,UserDetailsServiceImpl user) throws Exception {
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetails).
				passwordEncoder(bcrpt).and().build();
		
		
	}
	
	
}
