package com.seleniumsalesforce.core;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.seleniumsalesforce.sftable.TableButton;
import com.seleniumsalesforce.sftable.TableCheckbox;

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
		
		int get_url_request_responseCode(String url);
		
		boolean is_clickable(WebElement element);
		
		boolean is_element_present(List<WebElement> element);
		
		void js_click(WebElement element);
		
		void js_enter(WebElement element,String text);
		
		void js_enter_chr_by_chr(WebElement element, String text);
		
		boolean js_is_readonly(WebElement element);
		
		void js_set_attribute(WebElement element, String attName, String attValue);
		
		void mouse_click(WebElement element);
		
		void press_keyboard_button(int vkEnter);
		
		void press_keyboard_selenium(WebElement element, Keys key);
		
		void select_value_from_dropdown( WebElement element,String value);
		
		void wait_for_element_to_present(String xpath, int waittime);

		void wait_for_element_to_present(By by, int waittime);
		
		void wait_for_element_to_present(ArrayList<String> arraylist, int waittime);
		
		void wait_for_element_clickable(WebElement element, int wait_time);

		boolean js_is_disabled(WebElement element);
		
	}

	interface Salesforce{
		Pattern pattern();
		Traverse traverse();
	}

	interface Traverse {

	}
	
	interface Pattern extends SearchContextsf{
	
	}

	interface Click{
		
		TableButton table_button();
		
		Execute button(String text);
		Execute button(String text,int obj_prp_index);
		Execute button(String text,int obj_prp_index,int html_str_index);
		Execute button_contains(String text,int obj_prp_index,int html_str_index);
		Execute button_attribute(String text,int obj_prp_index,int html_str_index);
		
		void textfield(String text);
		void textfield(String text,int obj_prp_index);
		void textfield(String text,int obj_prp_index,int html_str_index);

		void link(String text);
		void link(String text,int obj_prp_index);
		void link(String text,int obj_prp_index,int html_str_index);
		
		void textarea(String text);
		void textarea(String text,int obj_prp_index);
		void textarea(String text,int obj_prp_index,int html_str_index);

		void image(String text);
		void image(String text,int obj_prp_index);
		void image(String text,int obj_prp_index,int html_str_index);
		
	}
	
	interface Select{
	
		void checkbox(String labelname);
		void checkbox(String labelname, int obj_prp_index);
		void checkbox(String labelname,int obj_prp_index,int html_str_index);

		void raiobox(String labelname);
		void raiobox(String labelname, int obj_prp_index);
		void raiobox(String labelname,int obj_prp_index,int html_str_index);

		void dropdown(String labelname, String value);
		void dropdown(String labelname, String value, int obj_prp_index);
		void dropdown(String labelname,String value, int obj_prp_index,int html_str_index);
		
		void lightning_dropdown(String labelname, String value);
		void lightning_dropdown(String labelname, String value, int obj_prp_index);
		void lightning_dropdown(String labelname,String value, int obj_prp_index,int html_str_index);
		
		void lightning_dropdown_type(String labelname, String value);
		void lightning_dropdown_type(String labelname, String value, int obj_prp_index);
		void lightning_dropdown_type(String labelname,String value, int obj_prp_index,int html_str_index);

		ElementFind checkbox();
		ElementFind raiobox();
		ElementFind dropdown();
		ElementFind lightning_dropdown();
		ElementFind lightning_dropdown_type();

		TableCheckbox table_checkbox();
	
	}
	
	interface Input{
		
		void textfield(String label,String value);
		void textfield(String label,String value,int obj_prp_index);
		void textfield(String label,String value,int obj_prp_index,int html_str_index);
		
		void textarea(String label,String value);
		void textarea(String label,String value,int obj_prp_index);
		void textarea(String label,String value,int obj_prp_index,int html_str_index);

		void js_texteditor(String label,String value);
		void js_texteditor(String label,String value,int obj_prp_index);
		void js_texteditor(String label,String value,int obj_prp_index,int html_str_index);
		
		ElementFind textfield();
		ElementFind textarea();
		ElementFind js_texteditor();

		Execute tablecell(String text);
		Execute tablecell(String text,int obj_prp_index);
		Execute tablecell(String text,int obj_prp_index,int html_str_index);

		Execute tablecell(String text, String col_number);
		Execute tablecell(String text, String col_number,int obj_prp_index);
		Execute tablecell(String text, String col_number,int obj_prp_index,int html_str_index);

		Execute tablecell(String text, String col_number, String another_cell);
		Execute tablecell(String text, String col_number,String another_cell,int obj_prp_index);
		Execute tablecell(String text, String col_number,String another_cell,int obj_prp_index,int html_str_index);

		Execute tablecell(String text, String col_number, String another_cell,String col_number2);
		Execute tablecell(String text, String col_number,String another_cell,String col_number2,int obj_prp_index);
		Execute tablecell(String text, String col_number,String another_cell,String col_number2,int obj_prp_index,int html_str_index);

	}
	
	interface Verify{
		
		void text(String text);
		void text(String text,int obj_prp_index);
		void text(String text,int obj_prp_index,int html_str_index);
		
		void text_fieldvalue(String label,String value);
		void text_fieldvalue(String label,String value,int obj_prp_index);
		void text_fieldvalue(String label,String value,int obj_prp_index,int html_str_index);
		
		void image(String object);
		void image(String object,int obj_prp_index);
		void image(String object,int obj_prp_index,int html_str_index);

		Execute tablecell(String text);
		Execute tablecell(String text,int obj_prp_index);
		Execute tablecell(String text,int obj_prp_index,int html_str_index);

		Execute tablecell(String text, String col_number);
		Execute tablecell(String text, String col_number,int obj_prp_index);
		Execute tablecell(String text, String col_number,int obj_prp_index,int html_str_index);

		Execute tablecell(String text, String col_number, String another_cell);
		Execute tablecell(String text, String col_number,String another_cell,int obj_prp_index);
		Execute tablecell(String text, String col_number,String another_cell,int obj_prp_index,int html_str_index);

		Execute tablecell(String text, String col_number, String another_cell,String col_number2);
		Execute tablecell(String text, String col_number,String another_cell,String col_number2,int obj_prp_index);
		Execute tablecell(String text, String col_number,String another_cell,String col_number2,int obj_prp_index,int html_str_index);

		
	}
}
