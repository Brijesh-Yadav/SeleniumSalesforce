package com.seleniumsalesforce.test;

import com.seleniumsalesforce.core.SalesforceLex;
import com.seleniumsalesforce.core.SoftDriver;

public class TestClass {
	
	public static void main(String []args){
		SoftDriver driver = new SalesforceLex("Driver");
		driver.salesforce().pattern().click().button("submit");
	}

}
