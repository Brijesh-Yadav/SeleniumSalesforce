package com.seleniumsalesforce.classic.repo;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class Text_fieldvalue {
	
	public static ArrayList<String> text_fieldvalue_repo(String object_name, int index){
		LinkedHashSet<String> obj_list = new LinkedHashSet<String>();
		//added on 19 June 2021
		obj_list.add("(//button[text()=\""+object_name+"\"])["+index+"]");
		obj_list.add("(//*[text()=\""+object_name+"\"]/ancestor::button)["+index+"]");
		obj_list.add("(//div//input[@value=\""+object_name+"\"])["+index+"]");
		//convert hash to list
		ArrayList<String> arrlist = new ArrayList<String>(obj_list);
		return arrlist;
	}

}
