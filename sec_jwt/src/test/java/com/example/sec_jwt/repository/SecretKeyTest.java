package com.example.sec_jwt.repository;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.sec_jwt.entity.UserEntity;

import io.jsonwebtoken.Jwts;

@SpringBootTest
public class SecretKeyTest {

	@Autowired
	MembersRepository memberRepository;
	
	//@Value("${spring.jwt.secret}")
	String secret = "%sorkaksdlfgksmfdlfkaus$rmeofdnogoshfogkrpTths$orkaksdlfgksmfd$lfkausrmeofdnogoshfogkrpTth";
	
	SecretKey secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8),
            Jwts.SIG.HS256.key().build().getAlgorithm());
	
	
	public String createJwt(String username, String role, Long expiredMs) {
    	String jwt_key = Jwts.builder()
                .claim("username", username)
                .claim("role", role)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiredMs))
                .signWith(secretKey)
                .compact();
    	
    	System.out.println("jwt : " + jwt_key);
        return jwt_key;
    }
	
	@Test
	public void test() {
		UserEntity user = memberRepository.findByUsername("user01");
		
		String key = createJwt(user.getUsername(), user.getRole(), 1l);
		System.out.println(key);
	}
}
