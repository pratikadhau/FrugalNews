package com.news.frugal.commom.pojo;

public class NewsServiceResponse<Res> {
	private Res response;
	private String errorCode;
	private String errorMessage;

	public Res getResponse() {
		return response;
	}

	public void setResponse(Res response) {
		this.response = response;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "NewsServiceResponse [response=" + response + ", errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}
}