package com.intuit.test.stockTrading.exceptions;

public class ErrorMessage {
	
	public ErrorMessage() {
	
	}

	public ErrorMessage(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	private String errorMsg;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
}
