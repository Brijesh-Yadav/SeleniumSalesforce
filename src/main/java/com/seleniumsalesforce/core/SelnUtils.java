package com.seleniumsalesforce.core;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.seleniumsalesforce.core.SoftDriver.SeleniumUtils;

public class SelnUtils implements SeleniumUtils{
	
	private WebDriver w_driver;

	public SelnUtils(WebDriver w_driver) {
		// TODO Auto-generated constructor stub
		this.w_driver = w_driver;
	}

	@Override
	public void click(WebElement element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enter(WebElement element, String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void staticwait(int wait_time) {
		// TODO Auto-generated method stub
		System.out.println("wait for "+wait_time);
	}

	@Override
	public WebElement return_Webelement(String xpath_obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WebElement> return_WebElements(String xpath_obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String get_url_request_responseCode(String url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean is_clickable(WebElement element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean is_element_present(List<WebElement> element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void js_click(WebElement element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void js_enter(WebElement element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void js_enter_chr_by_chr(WebElement element, String text) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean js_is_disabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean js_is_readonly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void js_set_attribute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouse_click() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void press_keyboard_button() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void press_keyboard_selenium() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void select_value_from_dropdown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void is_selected() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wait_for_element_to_present(String xpath, int waittime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wait_for_element_to_present(ArrayList<String> arraylist, int waittime) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wait_for_element_clickable(WebElement element, int wait_time) {
		// TODO Auto-generated method stub
		
	}

}
