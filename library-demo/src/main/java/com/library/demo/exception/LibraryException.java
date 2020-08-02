/**
*
* @author Avanesh Sharma
* 
*/
package com.library.demo.exception;

public class LibraryException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String code;
	private String message;

	public LibraryException() {
		super();
	}

	public LibraryException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public LibraryException(String message) {
		super();
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
