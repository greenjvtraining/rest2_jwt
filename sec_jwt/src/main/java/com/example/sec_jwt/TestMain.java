package com.example.sec_jwt;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class TestMain {
	public static void main(String[] args) {
		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		
		String jws = Jwts.builder()
				.setSubject("user")
				.signWith(key, SignatureAlgorithm.HS256)
				.compact();
		
		System.out.println(jws);
	}
}
