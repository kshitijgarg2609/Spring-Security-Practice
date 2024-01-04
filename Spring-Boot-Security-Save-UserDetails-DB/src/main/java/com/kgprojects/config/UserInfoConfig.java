package com.kgprojects.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.kgprojects.entity.UserInfo;
import com.kgprojects.service.UserInfoService;

@Component
public class UserInfoConfig implements UserDetailsService
{
	@Autowired
	private UserInfoService service;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		UserInfo u = service.getUserInfo(username);
		System.out.println("______________________________________________________________________");
		System.out.println(u);
		System.out.println("______________________________________________________________________");
		return User.withUsername(u.getUserName())
		.password(u.getPassword())
		.roles(u.getRole())
		.build();
	}
}