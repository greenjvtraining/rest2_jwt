package com.example.sec_jwt.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.sec_jwt.entity.UserEntity;
import com.example.sec_jwt.repository.MembersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private MembersRepository membersRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("username : " + username);
		
		UserEntity member = membersRepository.findByUsername(username);
		
		System.out.println("userEntity : " + member);
		
		if(member != null) {
			CustomUserDetails userData = new CustomUserDetails(member);
			return userData;
		}
		
		return null;
	}

}
