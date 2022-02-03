package com.seedtag.objectiveselector.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

// TODO: Simplified Exception class. It's pending to externalize i18n messages.
// Pending to handle Exceptions with an API error response
@Data
@EqualsAndHashCode(callSuper=false)
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String code;
	private String title;

	public BusinessException(String code, String title, String message) {
		super(message);
		this.code = code;
		this.title = title;
	}
}
