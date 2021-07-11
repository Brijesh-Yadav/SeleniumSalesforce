package com.seleniumsalesforce.exception;

public class DropdownValueNotFound extends SdriverException{
	
    public DropdownValueNotFound() {
        super();
    }

    public DropdownValueNotFound(String message) {
        super(message);
    }

    public DropdownValueNotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public DropdownValueNotFound(Throwable cause) {
        super(cause);
    }


}
