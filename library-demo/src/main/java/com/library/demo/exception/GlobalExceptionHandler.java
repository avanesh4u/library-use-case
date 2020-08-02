/**
*
* @author Avanesh Sharma
* 
*/
package com.library.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.library.demo.constants.ResponseCode;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex) {
		ErrorResponse errorDetails = new ErrorResponse(String.valueOf(ResponseCode.INTERNAL_SERVER), ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	protected ResponseEntity<ErrorResponse> handleGlobalExceptions(MethodArgumentNotValidException ex,
			WebRequest request) {
		String error = ex.getBindingResult().getFieldErrors().stream().map(err -> err.getDefaultMessage())
				.collect(java.util.stream.Collectors.joining(", "));
		ErrorResponse errorDetails = new ErrorResponse(String.valueOf(ResponseCode.INTERNAL_SERVER), error);

		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

}
