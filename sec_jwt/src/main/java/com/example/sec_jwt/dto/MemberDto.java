package com.example.sec_jwt.dto;

import lombok.Data;

@Data
public class MemberDto {

	private int mno;
	private String username;
	private String password;
	//private String nickname;
	private String role;
}
