package com.seleniumsalesforce.object.repo;

import java.util.ArrayList;

public class Radiobox {
	
	public ArrayList<String> radiobox_repo(String object_name, int index){
		ArrayList<String> obj_list = new ArrayList<String>();
		//added on 19 June 2021
		obj_list.add("(//button[text()=\""+object_name+"\"])["+index+"]");
		return obj_list;
	}


}
