package com.seleniumsalesforce.core;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface SoftDriver {

	Salesforce salesforce();
	
	SeleniumUtils seleniumutils();
	
	DateUtils date();
	
	ExcelUtils excelutils();
	
	interface DateUtils{
		
	}

	interface ExcelUtils{
		
	}

	interface SeleniumUtils{
		
		void click(WebElement element);
		
		void enter(WebElement element, String text);
		
		void staticwait(int wait_time);
		
		WebElement return_Webelement(String xpath_obj);
		
		List<WebElement> return_WebElements(String xpath_obj);
		
		String get_url_request_responseCode(String url);
		
		boolean is_clickable(WebElement element);
		
		boolean is_element_present(List<WebElement> element);
		
		void js_click(WebElement element);
		
		void js_enter(WebElement element);
		
		void js_enter_chr_by_chr(WebElement element, String text);
		
		boolean js_is_disabled();
		
		boolean js_is_readonly();
		
		void js_set_attribute();
		
		void mouse_click();
		
		void press_keyboard_button();
		
		void press_keyboard_selenium();
		
		void select_value_from_dropdown();
		
		void is_selected();
		
		void wait_for_element_to_present(String xpath, int waittime);
		
		void wait_for_element_to_present(ArrayList<String> arraylist, int waittime);
		
		void wait_for_element_clickable(WebElement element, int wait_time);
	}

	interface Salesforce{
		Pattern pattern();
		Traverse traverse();
	}

	interface Traverse {
		Click click();
		Select select();
		Input input();
	}
	
	interface Pattern {
		Click click();
		Select select();
		Input input();
	}
	
	interface Click{
		void button(String text);
		void button(String text,int obj_prp_index);
		void button(String text,int obj_prp_index,int html_str_index);
		
		void textfield(String text);
		void link(String text);
		void textarea(String text);
	}
	
	interface Select{
		void checkbox();
		void raiobox();
		void dropdown();
	}
	
	interface Input{
		void textfield();
		void textarea();
		void js_texteditor();
	}
}
