package com.seleniumsalesforce.core;

import java.util.LinkedHashMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Execute {
	
	private WebDriver w_driver;
	private LinkedHashMap<String,String> hashmap_obj;
	private String action;
	
	Execute(WebDriver w_driver, String action){
		this.w_driver = w_driver;
	}

	Execute(WebDriver w_driver, String action, LinkedHashMap<String,String> hashmap_obj){
		this.w_driver = w_driver;
		this.hashmap_obj = hashmap_obj;
		this.action = action;
	}
	
	public void perform(){
		SFutil sl = new SFutil(w_driver);
		switch(action){
		case "click":
			System.out.println("click");
			sl.perform_click(hashmap_obj,1);
		case "input":
			System.out.println("input");
		case "select":
			System.out.println("select");
		case "verify":
			System.out.println("verify");
		case "table":
			System.out.println("table");
		}
	}
	
	public WebElement return_element(){
		WebElement element = null;
		
		return element;
	}

}
