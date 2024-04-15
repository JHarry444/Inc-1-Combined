package com.qa.inc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "No item found with that id")
public class ItemNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8275753499319961732L;

}
