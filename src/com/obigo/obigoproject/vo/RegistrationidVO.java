package com.obigo.obigoproject.vo;

public class RegistrationidVO {
	private String userId;
	private String registrationId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	@Override
	public String toString() {
		return "RegistrationidVO [userId=" + userId + ", registrationId=" + registrationId + "]";
	}

}
