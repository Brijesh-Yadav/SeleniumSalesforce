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
		//initialize Salesforce driver
		SoftDriver sdriver = new SalesforceLex(driver);
		sdriver.salesforce().pattern().input().textfield("Search", "Dell Core i3");
		sdriver.salesforce().pattern().click().button("account").perform();
		sdriver.salesforce().pattern().select().checkbox("");
		sdriver.salesforce().pattern().click().button("account").return_element();
		sdriver.seleniumutils();
		sdriver.salesforce().pattern().verify().text("");
		sdriver.salesforce().pattern().click().
		table_button().tablecell("").perform();
		sdriver.seleniumutils().staticwait(10);
		driver.close();
	}

}
