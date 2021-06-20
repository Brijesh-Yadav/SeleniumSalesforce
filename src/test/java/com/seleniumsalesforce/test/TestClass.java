package com.seleniumsalesforce.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.seleniumsalesforce.core.SalesforceLex;
import com.seleniumsalesforce.core.SoftDriver;

public class TestClass {
	
	public static void main(String []args){
		System.out.println("initializing driver..");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/resources/driver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		// Initialize browser
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
		SoftDriver sdriver = new SalesforceLex(driver);
		sdriver.salesforce().pattern().click().button("submit",1,2);
		sdriver.salesforce().pattern().click().button("account");
		sdriver.seleniumutils().staticwait(10);
		driver.close();
	}

}
