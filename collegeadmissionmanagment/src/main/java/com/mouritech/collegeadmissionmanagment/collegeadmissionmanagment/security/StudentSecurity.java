package com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.mouritech.collegeadmissionmanagment.collegeadmissionmanagment.serviceimpl.CustomAdminService;

@Configuration
public class StudentSecurity {
	
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		//http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
		http.authorizeHttpRequests().requestMatchers("/sendCredentails").permitAll(); 
		//http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		//http.authorizeHttpRequests().requestMatchers("/getAllStudents").permitAll(); 
		//http.authorizeHttpRequests().requestMatchers("/getAllStudentsByPagination").permitAll(); 
		http.authorizeHttpRequests().requestMatchers("/sendStudentDetails").hasAuthority("ADMIN").and().
		authorizeHttpRequests().requestMatchers("/getAllStudentsByPagination").hasAuthority("ADMIN").
		anyRequest().authenticated();
		http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		http.csrf().disable();
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
		
	}
	
	@Bean
	public UserDetailsService userDetailService()
	{
		return new CustomAdminService();
		
	}
	@Bean
    public	AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailService());
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
		
	}

}
