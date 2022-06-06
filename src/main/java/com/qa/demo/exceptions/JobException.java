package com.qa.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Job not found")
public class JobException extends Exception {

	private static final long serialVersionUID = -2290680348355160843L;

}
