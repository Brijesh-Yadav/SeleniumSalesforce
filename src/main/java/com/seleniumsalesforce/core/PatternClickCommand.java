package com.seleniumsalesforce.core;

import com.seleniumsalesforce.core.SoftDriver.Click;
import com.seleniumsalesforce.core.SoftDriver.Input;
import com.seleniumsalesforce.core.SoftDriver.Pattern;
import com.seleniumsalesforce.core.SoftDriver.Select;

public class PatternClickCommand implements Click, Pattern{
	
	String text ;
	PatternClickCommand(String text){
		this.text = text;
	}

	public Click click() {
		// TODO Auto-generated method stub
		return new PatternClickCommand(text);
	}
	
	public void button(String label) {
		// TODO Auto-generated method stub
		System.out.println("button "+text+" "+label);
	}

	public void textfield(String label) {
		// TODO Auto-generated method stub
		System.out.println("textfield "+text+" "+label);
	}

	public void link(String label) {
		// TODO Auto-generated method stub
		System.out.println("link "+text+" "+label);
	}

	public void textarea(String label) {
		// TODO Auto-generated method stub
		System.out.println("textarea "+text+" "+label);
	}

	public Select select() {
		// TODO Auto-generated method stub
		return new PatternSelectCommand(text);
	}

	public Input input() {
		// TODO Auto-generated method stub
		return new PatternInputCommand(text);
	}

}
