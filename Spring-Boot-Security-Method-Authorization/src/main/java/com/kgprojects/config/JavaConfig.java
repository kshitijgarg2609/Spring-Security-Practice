package com.kgprojects.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class JavaConfig
{
    @Bean
    PasswordEncoder getEncoder()
	{
		return new BCryptPasswordEncoder();
	}

    @Bean
    UserDetailsService userDetailsService(PasswordEncoder encoder)
	{
		UserDetails admin = User.withUsername("admin")
				.password(encoder.encode("123456789"))
				.roles("ADMIN")
				.build();
		UserDetails user = User.withUsername("xyz")
				.password(encoder.encode("123456789"))
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(Arrays.asList(admin,user));
	}

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		return http.httpBasic(Customizer.withDefaults()).build();
	}
}