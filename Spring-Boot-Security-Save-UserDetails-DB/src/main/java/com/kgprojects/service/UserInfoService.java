package com.kgprojects.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kgprojects.entity.UserInfo;
import com.kgprojects.repo.UserInfoRepo;

import jakarta.annotation.PostConstruct;

@Service
public class UserInfoService
{
	@Autowired
	private UserInfoRepo repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public UserInfo getUserInfo(String id)
	{
		Optional<UserInfo> op = repo.findById(id);
		return op.get();
	}
	
	public List<UserInfo> listAll()
	{
		return repo.findAll();
	}
	
	@PostConstruct
	public void sampleData()
	{
		List<UserInfo> list = Arrays
				.asList(UserInfo.build("admin", encoder.encode("123456789"), "ADMIN")
						,UserInfo.build("xyz", encoder.encode("123456789"), "USER"));
		for(UserInfo u : list)
		{
			System.out.println(u);
			Optional<UserInfo> op = repo.findById(u.getUserName());
			if(op.isEmpty())
			{
				repo.saveAndFlush(u);
			}
		}
	}
}