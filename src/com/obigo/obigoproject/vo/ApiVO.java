package com.obigo.obigoproject.vo;

public class ApiVO {
	private String apiName;
	private String responseToSend;

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
		return "ApiVO [apiName=" + apiName + ", responseToSend=" + responseToSend + "]";
	}

	/**
	 * 
	 * @param responseToSend
	 */
	public String getResponseToSend(String responseToSend){
		return "";
	}

}

