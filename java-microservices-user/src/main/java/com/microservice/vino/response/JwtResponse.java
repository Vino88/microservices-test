package com.microservice.vino.response;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String userId;
	private String username;
	private String email;

	public JwtResponse(String accessToken, String userId, String username, String email) {
		this.token = accessToken;
		this.userId = userId;
		this.username = username;
		this.email = email;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
