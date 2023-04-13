package com.sch.admin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class WebSecurityConfig {

	
	@Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
	  Exception{ http.csrf().disable(); 
	  // .authorizeHttpRequests() 
	  //.requestMatchers("/").permitAll() 
	  // .and() 
	  // .httpBasic();
	  
	  return http.build(); }
	 
	
	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() throws 
	Exception{
		return (web) -> web.ignoring().requestMatchers("/images/**", "/js/**", "/webjars/**");
	}
}	

//NB WebSecurityConfigurerAdaptor is now depricated and this affects all the commentted out codes. used the above code
//for such cofiguration

//@EnableWebSecurity
//@Configuration
//	@Configuration
//	public class WebSecurityConfigextends WebSecurityConfigurerAdapter
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		 http.csrf().disable();
//	}
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
//		super.configure(auth);
//	}

//}
