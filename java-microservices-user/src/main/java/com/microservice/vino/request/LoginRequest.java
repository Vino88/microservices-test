package com.microservice.vino.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
	
	private String email;
	
	private String phoneNumber;

	@NotBlank
	private String password;
}
