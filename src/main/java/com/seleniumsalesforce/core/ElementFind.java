package com.seleniumsalesforce.core;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementFind {
	
	private WebDriver w_driver ;
	private String obj_type ;
	
	ElementFind(WebDriver w_driver){
		this.w_driver = w_driver;
	}
	
	ElementFind(WebDriver w_driver, String obj_type){
		this.w_driver = w_driver;
		this.obj_type = obj_type;
	}

	
	public WebElement return_element(String label) {
		WebElement ele = null;
		// TODO Auto-generated method stub
		switch(obj_type){
			case "Button":
				System.out.println();
			case"Textfield":
				System.out.println();
			default:
				System.out.println();
		}
		return ele;
	}
	
	public WebElement return_element(String label, int html_ind) {
		WebElement ele = null;
		// TODO Auto-generated method stub
		return ele;
	}
	
	public WebElement return_element(String label, int html_ind, int obj_ind) {
		WebElement ele = null;
		// TODO Auto-generated method stub
		return ele;
	}
	
	public List<WebElement> return_element_list(String label, int html_ind) {
		List<WebElement> ele = null;
		// TODO Auto-generated method stub
		return ele;
	}
	
	public List<WebElement> return_element_list(String label, int html_ind, int obj_ind) {
		List<WebElement> ele = null;
		// TODO Auto-generated method stub
		return ele;
	}


}
