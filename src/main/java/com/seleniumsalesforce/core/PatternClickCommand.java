package com.seleniumsalesforce.core;

import org.openqa.selenium.WebDriver;

import com.seleniumsalesforce.core.SoftDriver.Click;
import com.seleniumsalesforce.core.SoftDriver.Input;
import com.seleniumsalesforce.core.SoftDriver.Pattern;
import com.seleniumsalesforce.core.SoftDriver.Select;

public class PatternClickCommand implements Click, Pattern{
	
	private WebDriver w_driver ;
	PatternClickCommand(WebDriver w_driver){
		this.w_driver = w_driver;
	}

	public Click click() {
		// TODO Auto-generated method stub
		return new PatternClickCommand(w_driver);
	}
	
	public Select select() {
		// TODO Auto-generated method stub
		return new PatternSelectCommand(w_driver);
	}

	public Input input() {
		// TODO Auto-generated method stub
		return new PatternInputCommand(w_driver);
	}
	
	public void button(String label) {
		SelnUtils sl = new SelnUtils(w_driver);
		
		// TODO Auto-generated method stub
		System.out.println("button  "+label);
	}

	public void textfield(String label) {
		// TODO Auto-generated method stub
		System.out.println("textfield  "+label);
	}

	public void link(String label) {
		// TODO Auto-generated method stub
		System.out.println("link  "+label);
	}

	public void textarea(String label) {
		// TODO Auto-generated method stub
		System.out.println("textarea  "+label);
	}

	public void button(String text, int obj_prp_index) {
		// TODO Auto-generated method stub
		
	}

	public void button(String text, int obj_prp_index, int html_str_index) {
		// TODO Auto-generated method stub
		System.out.println("text "+text);
	}

}
