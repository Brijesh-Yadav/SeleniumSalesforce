package com.seleniumsalesforce.core;

import com.seleniumsalesforce.core.SoftDriver.Pattern;
import com.seleniumsalesforce.core.SoftDriver.Salesforce;
import com.seleniumsalesforce.core.SoftDriver.Traverse;

public class DriverOptions implements Salesforce{

	String text ; 
	
	DriverOptions(String text){
		this.text = text;
	}

	public Pattern pattern() {
		// TODO Auto-generated method stub
		return new PatternClickCommand(text);
	}

	public Traverse traverse() {
		// TODO Auto-generated method stub
		return new TraverseCommand();
	}

	
}
