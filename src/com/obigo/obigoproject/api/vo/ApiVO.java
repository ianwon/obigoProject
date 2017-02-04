package com.obigo.obigoproject.api.vo;

public class ApiVO {
	private String apiName;
	private String responseToSend;
	private String url;
	private String body;

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public String getResponseToSend() {
		return responseToSend;
	}

	public void setResponseToSend(String responseToSend) {
		this.responseToSend = responseToSend;
	}

	@Override
	public String toString() {
		return "ApiVO [apiName=" + apiName + ", responseToSend=" + responseToSend + ", url=" + url + ", body=" + body + "]";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * 
	 * @param responseToSend
	 */
	public String getResponseToSend(String responseToSend) {
		return "";
	}

}
