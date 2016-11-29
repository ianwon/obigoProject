package com.obigo.obigoproject.vo;

public class UserVehicleVO {
	private String userId;
	private String modelCode;
	private String color;
	private String location;
	private String vin;
	private int userVehicleNumber;
	private int activeDtcCount;

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

	public int getUserVehicleNumber() {
		return userVehicleNumber;
	}

	public void setUserVehicleNumber(int userVehicleNumber) {
		this.userVehicleNumber = userVehicleNumber;
	}

	public int getActiveDtcCount() {
		return activeDtcCount;
	}

	public void setActiveDtcCount(int activeDtcCount) {
		this.activeDtcCount = activeDtcCount;
	}

	@Override
	public String toString() {
		return "UserVehicleVO [userId=" + userId + ", modelCode=" + modelCode + ", color=" + color + ", location=" + location + ", vin=" + vin + ", userVehicleNumber=" + userVehicleNumber
				+ ", activeDtcCount=" + activeDtcCount + "]";
	}

}
