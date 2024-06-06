package com.example.sec_jwt.controller;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")
    public String mainP() {
    	String name = SecurityContextHolder.getContext().getAuthentication().getName();

    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    	Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
    	Iterator<? extends GrantedAuthority> iter = authorities.iterator();
    	GrantedAuthority auth = iter.next();
    	String role = auth.getAuthority();
    	
        return "Main Controller username: "+name + ", role : " + role;
    }
    
    @GetMapping("/notice")
    public String notice() {
    	return "notice............";
    }
    
    //@GetMapping("/login")
    public String loginForm() {
    	System.out.println("loginForm................");
    	return "loginForm";
    }
    
    
}
