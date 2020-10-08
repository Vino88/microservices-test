package com.microservice.vino.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.microservice.vino.entity.User;
import com.microservice.vino.repository.UserRepository;
import com.microservice.vino.request.SignupRequest;
import com.microservice.vino.response.ViewProfileResponse;
import com.microservice.vino.util.Response;

@Component
public class ProfileHelperComponent {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder encoder;
	
	public void createUser(SignupRequest signUpRequest) {
		
		User user = new User();
		user.setUsername(signUpRequest.getUsername());
		user.setEmail(signUpRequest.getEmail());
		user.setPassword(encoder.encode(signUpRequest.getPassword()));
		user.setFirstName(signUpRequest.getFirstName());
		user.setLastName(signUpRequest.getLastName());
		user.setGender(signUpRequest.getGender());
		user.setDob(signUpRequest.getDateOfBirth());
		user.setPhoneNumber(signUpRequest.getPhoneNumber());

		userRepository.save(user);
	}
	
	public Response<ViewProfileResponse> getViewProfile(String userId) {
		User user = userRepository.findByUsername(userId);
		ViewProfileResponse dto = new ViewProfileResponse();
		if(user != null) {
			dto.setFirstName(user.getFirstName());
			dto.setLastName(user.getLastName());
			dto.setGender(user.getGender());
			dto.setDateOfBirth(user.getDob());
		}
		
		return new Response<ViewProfileResponse>(dto);
	}
	
	public void updateUser(String userId, ViewProfileResponse update) {
		User user = userRepository.findByUsername(userId);
		user.setFirstName(update.getFirstName());
		user.setLastName(update.getLastName());
		user.setGender(update.getGender());
		user.setDob(update.getDateOfBirth());
		userRepository.save(user);
	}
}
