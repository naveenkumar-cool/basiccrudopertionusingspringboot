package com.example.exception;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundExe.class)
	public ResponseEntity<ErrorResponse> httpResoruceNotFoundException(ResourceNotFoundExe exception,
			WebRequest request) {
		ErrorResponse errorResponse = ErrorResponse.builder().status(exception.getStatus()).date(new Date())
				.details(request.getDescription(false)).message(exception.getMessage()).build();
		return new ResponseEntity<ErrorResponse>(errorResponse, exception.getStatus());
	}

}


