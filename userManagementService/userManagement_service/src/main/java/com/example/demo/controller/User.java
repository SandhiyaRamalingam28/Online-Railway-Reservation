package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User {
	
	@RequestMapping("/Welcome")
	public String Welcome() {
		String text = " this is private page ";
		text += "this page is not allowed to unauthenticated users";
		return text;
	}
	
	@RequestMapping("/getUsers")
	public String getUsers() {
		
		return "train details";
	}

}
