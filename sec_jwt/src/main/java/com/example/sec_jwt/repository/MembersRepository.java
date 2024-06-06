package com.example.sec_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sec_jwt.entity.Members;
import com.example.sec_jwt.entity.UserEntity;

public interface MembersRepository extends JpaRepository<UserEntity, Integer>{

	public UserEntity findByUsername(String username);
	
	public Boolean existsByUsername(String username);
}
