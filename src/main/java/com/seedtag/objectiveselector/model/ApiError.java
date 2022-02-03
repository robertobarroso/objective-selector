package com.seedtag.objectiveselector.model;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;


public class ApiError {

	@Getter
	private HttpStatus status;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	
	@Getter
	private String code;
	
	@Getter
	private String title;
	
	@Getter
	private String message;
	
	@Getter
	private String debugMessage;

	private ApiError() {
		timestamp = LocalDateTime.now();
	}

	public ApiError(HttpStatus status, String code, String title, String message, Throwable ex) {
		this();
		this.status = status;
		this.code = code;
		this.title = title;
		this.message = message;
		this.debugMessage = ex.getLocalizedMessage();
	}
}