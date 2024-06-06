package com.example.sec_jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/members")
@RestController
public class UserController {

	@RequestMapping("/mypage")
	public String mypage() {
		System.out.println("members MyPage..............");
		return "mypage";
	}
}
