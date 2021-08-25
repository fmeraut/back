package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.services.impl.AppUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AppUserDetailsService appUserDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(appUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	
	protected void configure(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
				.anyRequest().authenticated() // toutes les requêtes doivent passées par la procédure de connexion
			.and()
			.formLogin()
				.permitAll() // il faut faire la connexion avant d'ouvrir la ressource
			.and()
			.logout()
				.logoutUrl("/logout") // un Url pour faire la déconnexion
				.permitAll()
			.and()
			.httpBasic() // la mêthode de sécurité
			.and()
			.csrf().disable(); //désactivé le cross-site request forgery
		
	}
	
}
