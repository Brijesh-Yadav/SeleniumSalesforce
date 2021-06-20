package com.seleniumsalesforce.core;

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
		
		void click();
		
		void enter();
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
