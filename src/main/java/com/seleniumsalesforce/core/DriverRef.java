package com.seleniumsalesforce.core;

import org.openqa.selenium.WebDriver;

public class DriverRef {
	
	private WebDriver driver;
	
	public void SetDriver(WebDriver driver){
		this.driver = driver;
	}
	
	public WebDriver getDriver(){
		return driver;
	}

}
