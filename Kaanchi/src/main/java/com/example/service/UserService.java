package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    public LoginResponseDto login(LoginDto loginDto) {
        Optional<Users> optionalEmployee = userrepository.findByUserName(loginDto.getUserName());

        if (optionalEmployee.isPresent()) {
            Users user = optionalEmployee.get();

            // Check if password matches
            if (passwordencoder.matches(loginDto.getPassword(), user.getPassword())) {

                // Generate JWT token with the user's role
                String role = user.getRoles().name();
                String token = jwtservice.generateToken(user.getUserName(), List.of(role));

                // Prepare response DTO
                LoginResponseDto loginResponseDto = new LoginResponseDto();
                loginResponseDto.setToken(token);
                loginResponseDto.setRole(role);
                loginResponseDto.setName(user.getUserName());

                return loginResponseDto;
            }
        }
        return null;  // Return null if authentication fails
    }

}
