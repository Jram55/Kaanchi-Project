package com.example.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserInfoDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String username;
	
	@JsonIgnore
	private String password;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	
	public UserInfoDetails(Users user) {
		this.username=user.getUserName();
	    this.password=user.getPassword();
	      this.authorities= Stream.of(user)
	    		  .map(e->new SimpleGrantedAuthority(e.getRoles().name()))
	                .collect(Collectors.toList());
	    }
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		return authorities;
	}

	@Override
	public String getPassword() {
	
		return this.password;
	}

	@Override
	public String getUsername() {
	
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
	
		return true;
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

	
	
}
