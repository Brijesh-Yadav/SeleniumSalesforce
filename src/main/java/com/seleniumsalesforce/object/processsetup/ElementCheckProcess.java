package com.seleniumsalesforce.object.processsetup;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.seleniumsalesforce.core.DriverRef;
import com.seleniumsalesforce.core.SelnUtils;
import com.seleniumsalesforce.sfunction.SeleniumUtils;

public class ElementCheckProcess extends SelnUtils{
	
	ElementCheckProcess(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private ArrayList<String> check_multiple_obj(LinkedHashMap<String,String>object_list ){
		int ind = 0;
		ArrayList<String> list = new ArrayList<String>();
		for (Map.Entry<String, String> m : object_list.entrySet()) {
			String key_ob = m.getKey();
			String Key_vl = m.getValue();
			System.out.println("key object "+key_ob + " " + Key_vl+" index "+ind);
			List<WebElement> listobj = return_WebElements(key_ob);
			if(listobj.size()>0){
				list.add(key_ob);
			}
			ind++;
		}
		
		if(list.size()>1){
			System.out.println("Multiple html strucute are present.."+list.size()+" please specify index...");
			System.out.println("Function may not work.. if you don't");
		}
		return list;
	}

}
