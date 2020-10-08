package com.microservice.vino.response;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewProfileResponse {

	private String firstName;
	private String lastName;
	private String gender;
	private Date dateOfBirth;
}
