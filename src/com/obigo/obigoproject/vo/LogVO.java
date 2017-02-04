package com.obigo.obigoproject.vo;

public class LogVO {
	private String dateTime;
	private String body;
	private String url;
	private String returned;

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getReturned() {
		return returned;
	}

	public void setReturned(String returned) {
		this.returned = returned;
	}

	@Override
	public String toString() {
		return "LogVO [dateTime=" + dateTime + ", body=" + body + ", url=" + url + ", returned=" + returned + "]";
	}

}
