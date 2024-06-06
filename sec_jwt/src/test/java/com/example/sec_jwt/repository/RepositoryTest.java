package com.example.sec_jwt.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.sec_jwt.entity.UserEntity;

@SpringBootTest
public class RepositoryTest {
	
	@Autowired
	MembersRepository mRepository;
	
	
	@Test
	public void test() {
		UserEntity member = mRepository.findByUsername("user01");
		
	}
}
