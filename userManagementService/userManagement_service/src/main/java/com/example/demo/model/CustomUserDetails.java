package com.example.demo.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails{
	
	private UserModel userModel;
	
	public CustomUserDetails(UserModel userModel) {
		this.userModel= userModel;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities(){
		
		SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userModel.getId());
		return List.of(simpleGrantedAuthority);
	}
	
	@Override
	public String getPassword() {
		return userModel.getPassword();
	}
	
	@Override
	public String getUsername() {
		return userModel.getUsername();
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return true;
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}


}
