package com.seleniumsalesforce.core;

public interface Repository {
	
	Salesforceclassic sfclassic();
	Salessforcelex sflex();
	
	interface Salesforceclassic{
		
	}
	
	interface Salessforcelex{
		void print_button_obj();
		void print_link_obj();
		void print_dropdown_obj();
	}

}
