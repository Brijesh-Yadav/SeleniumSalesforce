package com.seleniumsalesforce.core;

import org.openqa.selenium.WebDriver;

import com.seleniumsalesforce.core.SoftDriver.Click;
import com.seleniumsalesforce.core.SoftDriver.Input;
import com.seleniumsalesforce.core.SoftDriver.Pattern;
import com.seleniumsalesforce.core.SoftDriver.Select;

public class PatternSelectCommand implements Select, Pattern{

	private WebDriver w_driver ;
	
	PatternSelectCommand(WebDriver w_driver){
		this.w_driver = w_driver;
	}

	public Select select() {
		// TODO Auto-generated method stub
		return new PatternSelectCommand(w_driver);
	}

	public Input input() {
		// TODO Auto-generated method stub
		return new PatternInputCommand(w_driver);
	}

	public Click click() {
		// TODO Auto-generated method stub
		return new PatternClickCommand(w_driver);
	}

	public void checkbox() {
		// TODO Auto-generated method stub
		System.out.println("checkbox");
	}

	public void raiobox() {
		// TODO Auto-generated method stub
		System.out.println("radiobox");
	}

	public void dropdown() {
		// TODO Auto-generated method stub
		System.out.println("dropdown");
	}

}
