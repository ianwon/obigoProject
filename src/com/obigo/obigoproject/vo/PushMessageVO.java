package com.obigo.obigoproject.vo;

public class PushMessageVO {
	private int messageNumber;
	private String title;
	private String content;
	private String sendDate;
	private String uploadFile;
	private String modelCode;
	private String location;
	private int categoryNumber;

	public int getMessageNumber() {
		return messageNumber;
	}

	public void setMessageNumber(int messageNumber) {
		this.messageNumber = messageNumber;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public String getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(String uploadFile) {
		this.uploadFile = uploadFile;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getCategoryNumber() {
		return categoryNumber;
	}

	public void setCategoryNumber(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}

	@Override
	public String toString() {
		return "PushMessageVO [messageNumber=" + messageNumber + ", title=" + title + ", content=" + content
				+ ", sendDate=" + sendDate + ", uploadFile=" + uploadFile + ", modelCode=" + modelCode + ", location="
				+ location + ", categoryNumber=" + categoryNumber + "]";
	}

}
