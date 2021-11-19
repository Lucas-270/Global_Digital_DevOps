package br.com.mercadao99.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	//autorizacao
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/companies", "/create-users")
			.authenticated().anyRequest()
			.permitAll()
			.and()
			.formLogin()
			.and()
			.logout()
			.logoutSuccessUrl("/")
			.and()
			.csrf().disable();
		
		http.headers().frameOptions().disable();
	}

}
