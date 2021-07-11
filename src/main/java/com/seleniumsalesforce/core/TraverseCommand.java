package com.seleniumsalesforce.core;

import com.seleniumsalesforce.core.SoftDriver.Click;
import com.seleniumsalesforce.core.SoftDriver.Input;
import com.seleniumsalesforce.core.SoftDriver.Select;
import com.seleniumsalesforce.core.SoftDriver.Traverse;
import com.seleniumsalesforce.sftable.TableButton;

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

	public Execute button(String text) {
		// TODO Auto-generated method stub
		System.out.println("traverse button");
		return null;
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

	public void button(String text, int obj_prp_index) {
		// TODO Auto-generated method stub
		
	}

	public void button(String text, int obj_prp_index, int html_str_index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void textfield(String text, int obj_prp_index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void textfield(String text, int obj_prp_index, int html_str_index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void link(String text, int obj_prp_index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void link(String text, int obj_prp_index, int html_str_index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void textarea(String text, int obj_prp_index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void textarea(String text, int obj_prp_index, int html_str_index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TableButton table_button() {
		// TODO Auto-generated method stub
		return null;
	}
}
