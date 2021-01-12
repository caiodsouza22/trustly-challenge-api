package com.caiodesouza.truslychallenge.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.caiodesouza.truslychallenge.services.exceptions.ResourceEmptyExpection;
import com.caiodesouza.truslychallenge.services.exceptions.ResourceNotFoundException;



@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";	
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(),status.value(), error,e.getMessage(), request.getRequestURI());
	    return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ResourceEmptyExpection.class)
	public ResponseEntity<StandardError> resourceEmpty(ResourceEmptyExpection e, HttpServletRequest request) {
		String error = "Repository is empty";	
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		StandardError err = new StandardError(Instant.now(),status.value(), error,e.getMessage(), request.getRequestURI());
	    return ResponseEntity.status(status).body(err);
	}
}
