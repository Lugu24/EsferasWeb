package com.dwa.webesferas;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
			.antMatchers(//ruta con acceso libre
						"/",
						"/css/**",
						"/js/**",
						"/Proyecto/**",
						"/cliente/**",
						"/cliente/Login"
					).permitAll()
			.anyRequest().authenticated()//cualquier otra ruta es ocn el token
			.and()
		.formLogin()
			.loginPage("/cliente/Login")//esta ruta se usa validar el usuario
			.successForwardUrl("/cliente/Login")
			.permitAll()
			.and()
		.logout()
			.permitAll(); 		
	}
}
