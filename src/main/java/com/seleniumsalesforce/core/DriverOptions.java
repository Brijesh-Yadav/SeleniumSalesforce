package com.seleniumsalesforce.core;

import org.openqa.selenium.WebDriver;

import com.seleniumsalesforce.core.SoftDriver.Pattern;
import com.seleniumsalesforce.core.SoftDriver.Salesforce;
import com.seleniumsalesforce.core.SoftDriver.Traverse;

public class DriverOptions implements Salesforce{

	private WebDriver w_driver ; 
	
	DriverOptions(WebDriver w_driver){
		this.w_driver = w_driver;
	}

	public Pattern pattern() {
		// TODO Auto-generated method stub
		return new PatternClickCommand(w_driver);
	}

	public Traverse traverse() {
		// TODO Auto-generated method stub
		return new TraverseCommand();
	}

	
}
