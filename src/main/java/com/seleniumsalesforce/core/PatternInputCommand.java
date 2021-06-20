package com.seleniumsalesforce.core;

import org.openqa.selenium.WebDriver;

import com.seleniumsalesforce.core.SoftDriver.Click;
import com.seleniumsalesforce.core.SoftDriver.Input;
import com.seleniumsalesforce.core.SoftDriver.Pattern;
import com.seleniumsalesforce.core.SoftDriver.Select;

public class PatternInputCommand implements Pattern, Input{

	private WebDriver w_driver ;
	
	PatternInputCommand(WebDriver w_driver){
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

	public void textfield() {
		// TODO Auto-generated method stub
		System.out.println("textfiedl");
	}

	public void textarea() {
		// TODO Auto-generated method stub
		System.out.println("text aread input");
	}

	public void js_texteditor() {
		// TODO Auto-generated method stub
		System.out.println("js text editor input");
	}


}
