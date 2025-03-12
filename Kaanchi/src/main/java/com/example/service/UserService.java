package com.example.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.utils.Constants;
import com.example.config.JwtService;
import com.example.dto.LoginDto;
import com.example.dto.LoginResponseDto;
import com.example.entity.Users;
import com.example.repository.UserDetailsRpository;

@Service
public class UserService {

	@Autowired
	private UserDetailsRpository userrepository;

	@Autowired
	private JwtService jwtservice;

	@Autowired
	private PasswordEncoder passwordencoder;



	public Users addUser(Users user) {
		user.setPassword(passwordencoder.encode(user.getPassword()));
		return userrepository.save(user);
	}

	public List<Users> getAlluser() {

		return userrepository.findAll();
	}

	public Users updateuser(Users user, Long userId) {
		Optional<Users> users = userrepository.findById(userId);

		if (users.isPresent()) {

			Users use = new Users();
			use.setUserName(use.getUserName());
			use.setPassword(use.getPassword());

			return userrepository.save(use);
		}
		return user;
	}

	public void deleteuser(Long userId) {
		userrepository.deleteById(userId);

	}

	public boolean login(LoginDto loginDto) {
		Optional<Users> _user = userrepository.findByUserName(loginDto.getUserName());
		if (_user.isPresent()) {
			Users user = _user.get();
			System.out.println(loginDto.getPassword());
			if (passwordencoder.matches(loginDto.getPassword(),user.getPassword())) {
				return true;
			}
			else {
			
				return false;
			}
		}
			else {
			return false;
	}
	}
	public LoginResponseDto getLoginData(LoginDto loginDto) {
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		Optional<Users> users = userrepository.findByUserName(loginDto.getUserName());
		if (!users.isEmpty()) {

			String token = jwtservice.generateToken(users.get().getUserName());
			loginResponseDto.setToken(token);
			return loginResponseDto;
		} else {
			return null;
		}
	}

}
