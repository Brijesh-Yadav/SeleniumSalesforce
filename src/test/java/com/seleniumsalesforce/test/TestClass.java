package com.seleniumsalesforce.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.seleniumsalesforce.core.SalesforceLex;
import com.seleniumsalesforce.core.SoftDriver;

public class TestClass {
	
	public static void main(String []args){
		WebDriver driver = new ChromeDriver();
		SoftDriver sdriver = new SalesforceLex(driver);
		sdriver.salesforce().pattern().click().button("submit",1,2);
		sdriver.salesforce().pattern().click().button("");
		sdriver.seleniumutils().click();
	}

}
