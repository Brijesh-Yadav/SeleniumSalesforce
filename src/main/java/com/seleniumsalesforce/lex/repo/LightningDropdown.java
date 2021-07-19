package com.seleniumsalesforce.lex.repo;

import java.util.LinkedHashMap;

public class LightningDropdown {
	
	public static LinkedHashMap<String,String> lightning_dropdown_repo(String label_name, int index){
		LinkedHashMap<String,String> hm = new LinkedHashMap<String, String>();
		hm.put("(//lightning-combobox/*[text()=\""+label_name+"\"])["+index+"]","/..//lightning-base-combobox-item");
		hm.put("(//*[text()=\""+label_name+"\"]/ancestor::div[1]/input)["+index+"]","/..//div[@class='address-selection']/div[@class='pl-label']");
		hm.put("(//label[text()=\""+label_name+"\"]/..//input)["+index+"]","/../following-sibling::div[1]//lightning-base-combobox-item");
		return hm;
	}

}
