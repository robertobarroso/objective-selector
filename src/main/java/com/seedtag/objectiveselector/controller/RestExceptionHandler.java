package com.seedtag.objectiveselector.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.seedtag.objectiveselector.exception.BusinessException;
import com.seedtag.objectiveselector.model.ApiError;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	// other exception handlers


	@ExceptionHandler(BusinessException.class)
	protected ResponseEntity<Object> handleBusinessEntity(BusinessException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getCode(), ex.getTitle(), ex.getMessage(), ex);
		return buildResponseEntity(apiError);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "SE-001", "Unexpected error", "An unexpected error has ocurred. Please, contact support", ex);
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Object> handleAllUncaughtException(RuntimeException ex, WebRequest request) {
		ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "SE-001", "Unexpected error", "An unexpected error has ocurred. Please, contact support", ex);
		return buildResponseEntity(apiError);
	}
	
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
}