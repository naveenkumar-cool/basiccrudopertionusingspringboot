package com.example.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ResourceNotFoundExe extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpStatus status;

	public ResourceNotFoundExe(HttpStatus status, String message) {
		super(message);
		this.status = status;
	}
}