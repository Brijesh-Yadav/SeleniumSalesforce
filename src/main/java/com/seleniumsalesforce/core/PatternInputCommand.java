package com.seleniumsalesforce.core;

import com.seleniumsalesforce.core.SoftDriver.Click;
import com.seleniumsalesforce.core.SoftDriver.Input;
import com.seleniumsalesforce.core.SoftDriver.Pattern;
import com.seleniumsalesforce.core.SoftDriver.Select;

public class PatternInputCommand implements Pattern, Input{

	String text;

	PatternInputCommand(String text){
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
