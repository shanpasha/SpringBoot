package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigaration {
	
	
	@Bean
	public SecurityFilterChain securitychain(HttpSecurity http) throws Exception {
		http.authorizeRequests((requests)->requests
				.antMatchers("/","/home").permitAll()
				.anyRequest().authenticated()).formLogin();
		return http.build();
}		
	
	
@Bean
	UserDetailsService userDetailsService() {
		
		UserDetails user=User.withDefaultPasswordEncoder()
				.username("shan")
				.password("shan").roles("user").build();
		return new InMemoryUserDetailsManager(user);
		
		
	}

}
