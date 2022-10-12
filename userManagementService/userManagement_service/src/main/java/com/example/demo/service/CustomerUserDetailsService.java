package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.CustomUserDetails;
import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;

@Service 
public class CustomerUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
//	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		
		final UserModel userModel = this.userRepository.findByUsername(userName);
		
		if(userModel == null) {
			throw new UsernameNotFoundException("User not found");
		}
		else {
			return new CustomUserDetails(userModel);
		}
		
//		if(userName.equals("Sandhiya")) {
//			return new User("Sandhiya","Sandhiya@123", new ArrayList<>());
//		}
//		else {
//			throw new UsernameNotFoundException("User not found");
//		}
	}
}
