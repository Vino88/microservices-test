package com.microservice.vino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.vino.response.ViewProfileResponse;
import com.microservice.vino.service.impl.ProfileHelperComponent;
import com.microservice.vino.util.MessageUtil;
import com.microservice.vino.util.Response;

@RestController
@RequestMapping("/rest/api/member")
public class UserController {

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	private ProfileHelperComponent profileHelperComponent;
	
	@GetMapping("/view")
	public Response<ViewProfileResponse> getProfile(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		final String userId = authentication.getName();
		System.out.println(userId);
		return profileHelperComponent.getViewProfile(userId);
	}
	
	@PostMapping("/update")
	public ResponseEntity<MessageUtil> updateUser(@RequestBody ViewProfileResponse update){
		MessageUtil message = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		final String userId = authentication.getName();
		if(update != null) {
			profileHelperComponent.updateUser(userId, update);
			message = new MessageUtil(200, "SUCCESS", "Data user has been update successful!");
		}else {
			message = new MessageUtil(400, "FAILED", "Bad Request");
		}
		return new ResponseEntity<MessageUtil>(message, HttpStatus.OK);
	}
}
