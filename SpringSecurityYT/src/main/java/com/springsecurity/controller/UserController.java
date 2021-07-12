package com.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@GetMapping("/account")
	public String account()
	{
		return "Hi Welcome";
	}
	
	@GetMapping("/balance")
	public String balance()
	{
		return "Your Balance = "+10000;
	}
	
	@GetMapping("/update")
	public String update()
	{
		return "we have an update for you";
	}
	
	@GetMapping("/main")
	public String mainPage()
	{
		return "This is main page";
	}

}
