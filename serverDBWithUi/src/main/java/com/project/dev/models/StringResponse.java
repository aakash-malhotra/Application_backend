package com.project.dev.models;

import org.springframework.stereotype.Component;

public class StringResponse {
	private String response;

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public StringResponse(String response) {
		super();
		this.response = response;
	}

	public StringResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StringResponse [response=" + response + "]";
	}
	
}