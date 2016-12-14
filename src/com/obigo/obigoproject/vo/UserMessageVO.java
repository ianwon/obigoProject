package com.obigo.obigoproject.vo;

public class UserMessageVO {
	private int userMessageNumber;
	private String userId;
	private int messageNumber;
	private String path;

	public int getUserMessageNumber() {
		return userMessageNumber;
	}

	public void setUserMessageNumber(int userMessageNumber) {
		this.userMessageNumber = userMessageNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getMessageNumber() {
		return messageNumber;
	}

	public void setMessageNumber(int messageNumber) {
		this.messageNumber = messageNumber;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "UserMessageVO [userMessageNumber=" + userMessageNumber + ", userId=" + userId + ", messageNumber="
				+ messageNumber + ", path=" + path + "]";
	}

}
