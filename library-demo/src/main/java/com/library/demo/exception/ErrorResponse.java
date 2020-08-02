/**
*
* @author Avanesh Sharma
* 
*/
package com.library.demo.exception;

public class ErrorResponse {

	private String errorCode;
	private String message;

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(String message) {
		super();
		this.message = message;
	}

	public ErrorResponse(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "ErrorResponse [ message=" + message + ", errorCode=" + errorCode + "]";
	}
}
