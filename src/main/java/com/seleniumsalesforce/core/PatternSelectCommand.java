package com.seleniumsalesforce.core;

import com.seleniumsalesforce.core.SoftDriver.Click;
import com.seleniumsalesforce.core.SoftDriver.Input;
import com.seleniumsalesforce.core.SoftDriver.Pattern;
import com.seleniumsalesforce.core.SoftDriver.Select;

public class PatternSelectCommand implements Select, Pattern{

	String text ;
	
	PatternSelectCommand(String text){
		this.text = text;
	}

	public Select select() {
		// TODO Auto-generated method stub
		return new PatternSelectCommand(text);
	}

	public Input input() {
		// TODO Auto-generated method stub
		return new PatternInputCommand(text);
	}

	public Click click() {
		// TODO Auto-generated method stub
		return new PatternClickCommand(text);
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
