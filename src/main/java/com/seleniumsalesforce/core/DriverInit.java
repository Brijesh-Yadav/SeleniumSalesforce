package com.seleniumsalesforce.core;

import org.openqa.selenium.WebDriver;

public class DriverInit implements  SoftDriver{

	private WebDriver w_driver;
	
	DriverInit(WebDriver w_driver){
		this.w_driver = w_driver;
	}
	
	public Salesforce salesforce() {
		// TODO Auto-generated method stub
		return new DriverOptions(w_driver);
	}

	public SeleniumUtils seleniumutils() {
		// TODO Auto-generated method stub
		return new SelnUtils(w_driver);
	}

	public DateUtils date() {
		// TODO Auto-generated method stub
		return null;
	}

	public ExcelUtils excelutils() {
		// TODO Auto-generated method stub
		return null;
	}


}
