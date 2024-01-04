package com.kgprojects.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserInfo
{
	@Id
	@Column(length = 32)
	private String userName;
	@Column(length = 100,nullable = false)
	private String password;
	@Column(length = 20, nullable = false)
	private String role;
	
	public static UserInfo build(String userName, String password, String role)
	{
		return new UserInfo(userName, password, role);
	}
	
	public UserInfo()
	{
		super();
	}
	
	public UserInfo(String userName, String password, String role)
	{
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getRole()
	{
		return role;
	}
	public void setRole(String role)
	{
		this.role = role;
	}
	@Override
	public String toString()
	{
		return "UserInfo [userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}
}