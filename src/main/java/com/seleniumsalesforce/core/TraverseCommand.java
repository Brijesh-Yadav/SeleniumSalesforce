package com.seleniumsalesforce.core;

import com.seleniumsalesforce.core.SoftDriver.Click;
import com.seleniumsalesforce.core.SoftDriver.Input;
import com.seleniumsalesforce.core.SoftDriver.Select;
import com.seleniumsalesforce.core.SoftDriver.Traverse;

public class TraverseCommand implements Click, Traverse{

	public Click click() {
		// TODO Auto-generated method stub
		return new TraverseCommand();
	}

	public Select select() {
		// TODO Auto-generated method stub
		return null;
	}

	public Input input() {
		// TODO Auto-generated method stub
		return null;
	}

	public void button(String text) {
		// TODO Auto-generated method stub
		System.out.println("traverse button");
	}

	public void textfield(String text) {
		// TODO Auto-generated method stub
		
	}

	public void link(String text) {
		// TODO Auto-generated method stub
		
	}

	public void textarea(String text) {
		// TODO Auto-generated method stub
		
	}

}
