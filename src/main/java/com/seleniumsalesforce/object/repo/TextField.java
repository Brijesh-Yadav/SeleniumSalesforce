package com.seleniumsalesforce.object.repo;

import java.util.ArrayList;

public class TextField {
	
	public ArrayList<String> textfield_repo(String object_name, int index){
		ArrayList<String> obj_list = new ArrayList<String>();
		//added on 19 June 2021
		obj_list.add("(//input[@title=\""+object_name+"\"])["+index+"]");
		obj_list.add("(//input[@name=\""+object_name+"\"])["+index+"]");
		obj_list.add("(//span[text()=\""+object_name+"\"]/ancestor::label[1]//input)["+index+"]");	
		obj_list.add("(//label[text()=\""+object_name+"\"]/..//input[@placeholder='Search People...'])["+index+"]");
		obj_list.add("(//span[text()=\""+object_name+"\"]/../following-sibling::div//input)[1]");	
		obj_list.add("(//span[text()=\""+object_name+"\"]/ancestor::div[1]//input)["+index+"]");	
		obj_list.add("(//label[text()=\""+object_name+"\"]/../div//input)["+index+"]");
		obj_list.add("(//label[text()=\""+object_name+"\"]/ancestor::lightning-input[1]/div/input)["+index+"]");
		return obj_list;
	}

}
