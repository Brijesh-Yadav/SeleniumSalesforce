package com.seleniumsalesforce.object.repo;

import java.util.ArrayList;

public class Link {
	
	public ArrayList<String> link_repo(String object_name, int index){
		ArrayList<String> obj_list = new ArrayList<String>();
		//added on 19 June 2021
		obj_list.add("(//*[text()=\""+object_name+"\"]/ancestor::a[1])["+index+"]");
		obj_list.add("(//ul/li/a[text()=\""+object_name+"\"])["+index+"]");
		obj_list.add("(//a[text()=\""+object_name+"\"])["+index+"]");
		obj_list.add("(//lightning-tabset/div/lightning-tab-bar/ul/li/a[text()=\""+object_name+"\"])["+index+"]");
		return obj_list;
	}

}
