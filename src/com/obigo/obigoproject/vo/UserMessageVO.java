package com.obigo.obigoproject.vo;

public class UserMessageVO {
	private int userMessageNumber;
	private String userId;
	private int messageNumber;

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

	@Override
	public String toString() {
		return "UserMessageVO [userMessageNumber=" + userMessageNumber + ", userId=" + userId + ", messageNumber=" + messageNumber + "]";
	}

}
