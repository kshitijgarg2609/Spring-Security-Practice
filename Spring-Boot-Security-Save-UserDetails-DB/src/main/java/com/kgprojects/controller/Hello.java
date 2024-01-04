package com.kgprojects.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Hello
{
	
	@GetMapping("/world")
	String hello()
	{
		return "hello world";
	}
	@GetMapping("/java")
	String java()
	{
		return "hello java";
	}
}