package com.seleniumsalesforce.test;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class TestClass2 {
	
	public static void main(String []args){
		TestClass2.HashSetToArrayConversion();
		
	}
	
	public static void HashSetToArrayConversion(){
		LinkedHashSet<String> obj_list = new LinkedHashSet<String>();
		//added on 19 June 2021
		obj_list.add("object 4");
		obj_list.add("object 1");
		obj_list.add("object 2");
		obj_list.add("object 2");
		obj_list.add("object 3");
		obj_list.add("object 2");
		
		ArrayList<String> arr = new ArrayList<String>(obj_list);
		
		for(int i=0; i<arr.size(); i++){
			System.out.println(arr.get(i));
		}
	}

}
