package com.example.sec_jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.sec_jwt.dto.JoinDto;
import com.example.sec_jwt.dto.MemberDto;
import com.example.sec_jwt.entity.UserEntity;
import com.example.sec_jwt.repository.MembersRepository;

@Service
public class MembersService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private MembersRepository membersRepository;
	
	public boolean registMember(MemberDto memberDto) {
	
		UserEntity member = new UserEntity();
		member.setUsername(memberDto.getUsername());
		String newPw = bCryptPasswordEncoder.encode(memberDto.getPassword());
		member.setPassword(newPw);
		member.setRole("ROLE_USER");
		
		UserEntity result = membersRepository.save(member);
		
		if(result != null) return true;
		
		return false;
	}

	public boolean joinProcess(JoinDto joinDto) {
		UserEntity member = new UserEntity();
		member.setUsername(joinDto.getUsername());
		String newPw = bCryptPasswordEncoder.encode(joinDto.getPassword());
		member.setPassword(newPw);
		member.setRole("ROLE_USER");
		
		UserEntity result = membersRepository.save(member);
		
		if(result != null) return true;
		
		return false;
	}
}
