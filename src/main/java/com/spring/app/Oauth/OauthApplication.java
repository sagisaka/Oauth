package com.spring.app.Oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.context.annotation.Bean;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
// @EnableWebSecurity
public class OauthApplication /*extends WebSecurityConfigurerAdapter*/{

	public static void main(String[] args) {
		SpringApplication.run(OauthApplication.class, args);
	}

	// @Bean
	// public UserDetailsService userDetailsService() {
	// 	InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	// 	manager.createUser(User.withUsername("user").password("password").roles("USER").build());
	// 	return manager;
	// }

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// 	http
	// 	.csrf().disable() // CSRF対策を無効化
	// 	.authorizeRequests()
	// 	.antMatchers("/login","/connect/twitter","/api/**").permitAll()
	// 	.anyRequest().authenticated();
	// }

}
