package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.example.config.UserInfoDetails;
import com.example.entity.Users;
import com.example.repository.UserDetailsRpository;

@Service

public class UserInfoDetailsService implements UserDetailsService{
	
	@Autowired
	private UserDetailsRpository userdeatilsrepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	  Optional<Users> user = userdeatilsrepository.findByUserName(username);
		if(user.isPresent()) {
			return new UserInfoDetails(user.get());
		}
		return null;

}
}
