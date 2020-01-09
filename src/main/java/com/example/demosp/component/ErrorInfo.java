package com.example.demosp.component;

public class ErrorInfo {

	private String url;
	private String message;

	public ErrorInfo(String url, String message) {
		super();
		this.url = url;
		this.message = message;
	}
	
	public ErrorInfo(String url, Exception exception) {
		super();
		this.url = url;
		this.message = exception.getMessage();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
