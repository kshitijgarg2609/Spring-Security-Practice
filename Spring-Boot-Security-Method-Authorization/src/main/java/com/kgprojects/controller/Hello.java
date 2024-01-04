package com.kgprojects.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Hello
{
	@GetMapping("/world")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	String hello()
	{
		return "hello world";
	}
	@GetMapping("/java")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	String java()
	{
		return "hello java";
	}
}