package com.seleniumsalesforce.core;

import org.openqa.selenium.WebDriver;

import com.seleniumsalesforce.core.SoftDriver.Pattern;
import com.seleniumsalesforce.core.SoftDriver.Salesforce;
import com.seleniumsalesforce.core.SoftDriver.Traverse;

public class DriverOptions implements Salesforce{
	
	private WebDriver driver;
	
	DriverOptions(WebDriver driver){
		this.driver = driver;
	}

	public Pattern pattern() {
		// TODO Auto-generated method stub
		return new PatternClickCommand(driver);
	}

	public Traverse traverse() {
		// TODO Auto-generated method stub
		return new TraverseCommand();
	}

	
}
