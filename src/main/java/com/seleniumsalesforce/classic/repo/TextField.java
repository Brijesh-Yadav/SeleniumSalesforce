package com.seleniumsalesforce.classic.repo;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class TextField {
	
	public static ArrayList<String> textfield_repo(String object_name, int index){
		LinkedHashSet<String> obj_list = new LinkedHashSet<String>();
		//added on 19 June 2021
		obj_list.add("(//input[@name=\""+object_name+"\"])["+index+"]");
		obj_list.add("(//input[@title=\""+object_name+"\"])["+index+"]");
		obj_list.add("(//input[@class=\""+object_name+"\"])["+index+"]");
		obj_list.add("(//input[@id=\""+object_name+"\"])["+index+"]");
		obj_list.add("(//label[text()=\""+object_name+"\"]/ancestor::div[1]//input)["+index+"]");
		obj_list.add("(//label/span[text()=\""+object_name+"\"]/ancestor::div[1]//input)["+index+"]");
		obj_list.add("(//label[text()=\""+object_name+"\"]/following-sibling::div[1]//input)["+index+"]");
		obj_list.add("(//label[text()=\""+object_name+"\"]/following-sibling::input)["+index+"]");
		//convert hash to list
		ArrayList<String> arrlist = new ArrayList<String>(obj_list);
		return arrlist;
	}

}
