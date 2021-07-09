package com.seleniumsalesforce.exception;

public class SdriverException extends RuntimeException {

	public SdriverException() {
		super();
	}

	public SdriverException(String message) {
		super(message);
	}

	public SdriverException(Throwable cause) {
		super(cause);
	}

	public SdriverException(String message, Throwable cause) {
		super(message, cause);
	}

}
