package com.seleniumsalesforce.exception;

public class ObjectNotFound extends SdriverException{
	
    public ObjectNotFound() {
        super();
    }

    public ObjectNotFound(String message) {
        super(message);
    }

    public ObjectNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public ObjectNotFound(Throwable cause) {
        super(cause);
    }


}
