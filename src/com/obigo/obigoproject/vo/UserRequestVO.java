package com.obigo.obigoproject.vo;

public class UserRequestVO {
	private int userRequestNumber;
	private String userId;
	private String modelCode;
	private String color;
	private String location;
	private String vin;

	public int getUserRequestNumber() {
		return userRequestNumber;
	}

	public void setUserRequestNumber(int userRequestNumber) {
		this.userRequestNumber = userRequestNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	@Override
	public String toString() {
		return "UserRequestVO [userRequestNumber=" + userRequestNumber + ", userId=" + userId + ", modelCode="
				+ modelCode + ", color=" + color + ", location=" + location + ", vin=" + vin + "]";
	}

}
