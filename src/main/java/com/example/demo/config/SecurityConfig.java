package com.example.demo.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	protected SecurityFilterChain fileterChain(HttpSecurity http) throws Exception{
		http
			.formLogin(
					login -> login
//					// 指定したURLがリクエストされるとログイン認証を行う。
//					.loginProcessingUrl("/login")
					// ログイン時のURLの指定
					.loginPage("/login").permitAll()
					// 認証成功後にリダイレクトする場所の指定
					.defaultSuccessUrl("/")
//					.usernameParameter("username")
//					.passwordParameter("password")
//					// ログインに失敗したときのURL
//					.failureUrl("/login?error")
					// アクセス権限の有無（permitAllはすべてのユーザーがアクセス可能）
					.permitAll()
			)
			.logout(logout -> logout
					.logoutSuccessUrl("/login?logout")
					.invalidateHttpSession(true)
			)
			.authorizeHttpRequests(authz -> authz
					.requestMatchers(PathRequest.toStaticResources().atCommonLocations())
					.permitAll()
					.anyRequest().authenticated()
			);
//		.formLogin()
//		.and()
//		.logout()
//		.and()
//		.authorizeHttpRequests(authz -> authz
//				.requestMatchers(PathRequest.toStaticResources().atCommonLocations())
//				.permitAll()
//				.anyRequest().authenticated()
//		);
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
