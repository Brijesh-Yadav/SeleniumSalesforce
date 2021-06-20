package com.seleniumsalesforce.object.repo;

import java.util.ArrayList;

public class TextArea {
	
	public ArrayList<String> textarea_repo(String object_name, int index){
		ArrayList<String> obj_list = new ArrayList<String>();
		//added on 19 June 2021
		obj_list.add("(//span[text()=\""+object_name+"\"]/ancestor::lightning-textarea[1]/div/textarea)["+index+"]");
		obj_list.add("(//label[text()=\""+object_name+"\"]/../div//textarea)["+index+"]");
		return obj_list;
	}

}
