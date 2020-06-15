package com.cg.busbooking.route.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
	
	//
	@ExceptionHandler(RouteIdNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleException(RouteIdNotFoundException exp) {
		ErrorMessage error = new ErrorMessage();
		error.setStatusCode(HttpStatus.BAD_GATEWAY.value());
		error.setErrorMessage(exp.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}

	@ExceptionHandler(RouteNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleException(RouteNotFoundException exp) {
		ErrorMessage error = new ErrorMessage();
		error.setStatusCode(HttpStatus.BAD_GATEWAY.value());
		error.setErrorMessage(exp.getMessage());
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
}
