package com.seleniumsalesforce.core;


public class DriverInit implements  SoftDriver{

	String text ;
	
	DriverInit(String text){
		this.text = text;
	}
	
	public Salesforce salesforce() {
		// TODO Auto-generated method stub
		return new DriverOptions(text);
	}

	public SeleniumUtils seleniumutils() {
		// TODO Auto-generated method stub
		return null;
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
