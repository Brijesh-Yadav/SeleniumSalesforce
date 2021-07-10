package com.seleniumsalesforce.core;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.seleniumsalesforce.exception.ObjectNotFound;

public class SFutil extends SelnUtils{
	
	private WebDriver sdriver;
	
	public SFutil(WebDriver w_driver) {
		super(w_driver);
		this.sdriver = w_driver;
		// TODO Auto-generated constructor stub
	}

	protected ArrayList<String> process_multiple_object_check(ArrayList<String> objectlist, int html_index){
		ArrayList<String> arraylist = new ArrayList<String>();
		if(html_index!=0){
			print_all_html_str(objectlist);
			System.out.println("below index was given.. from above html str..");
			String xpath = objectlist.get(html_index-1);
			System.out.println("index value is "+xpath);
			arraylist.add(xpath);
		}else{
			System.out.println("\n");
			//find element presence
			arraylist = add_all_html_str_tolist(objectlist);
			//check object siae
			if(arraylist.size()==0){
				System.out.println("arraylist size "+arraylist.size());
				//print indexing number
				print_all_html_str(objectlist);
				throw new ObjectNotFound("none of the html str is present..");
			}else if(arraylist.size()>=2){
				//print indexing number
				print_all_html_str(arraylist);
				System.out.println("\n");
				System.out.println("muliple html strucure pattern are present on the page for the same label text...");
				System.out.println("it's not handled in function.. handle it seprately..");
				System.out.println("try to use indexing from above printed data...");
			}
		}
		return arraylist;
	}
 
	private void print_all_html_str(ArrayList<String> objectlist){
		int ind = 1;
		for(int j=0; j<objectlist.size(); j++){
			String xpath_obj = objectlist.get(j);
			System.out.println(xpath_obj+ "  "+"indexing number is :: "+ind);
			ind++;
		}
	}
	
	private ArrayList<String> add_all_html_str_tolist(ArrayList<String> objectlist){
		System.out.println("Total object size in repo.."+objectlist.size());
		ArrayList<String> arraylist = new ArrayList<String>();
		int ind = 1;
		for(int i=0; i<objectlist.size(); i++){
			String xpath_obj = objectlist.get(i);
			List<WebElement> eleobj = return_WebElements(xpath_obj);
			if(eleobj.size()>0){
				System.out.println(xpath_obj+" element is present.. index number is :: "+ind);
				arraylist.add(xpath_obj);
			}
			ind++;
		}
		return arraylist;
	}
	
	protected LinkedHashMap<String,String>process_object_evaluation(ArrayList<String> arraylist){
		LinkedHashMap<String,String> mapobj = new LinkedHashMap<String,String>();
		for(int i=0; i<arraylist.size(); i++){
			String xpath_obj = arraylist.get(i);
			try{
				WebElement element = return_Webelement(xpath_obj);
				boolean result  = is_clickable(element);
				System.out.println("Element clickable state :: "+result);
				if(result==true){
					System.out.println("Element is found and its added in object list.. "+xpath_obj);
					mapobj.put(xpath_obj, "True");
				}else{
					mapobj.put(xpath_obj, "False");
				}
			}catch(TimeoutException et){
				System.out.println("Timeout exception occured !! - element is not present.. "+xpath_obj);
				mapobj.put(xpath_obj, "False");
			}
		}
		return mapobj;
	}
	
	private void sf_click_condition(WebElement element){
		String tagname = element.getTagName();
		System.out.println("sf__click tagname "+tagname);
		if("button".equalsIgnoreCase(tagname)){
			for(int i=1; i<15; i++){
				boolean st = js_is_disabled(element);
				if(st==false){
					System.out.println("button is enabled..");
					click(element);
					break;
				}else{
					System.out.println("button is disabled.. waiting to button get enabled..");
					staticwait(1);
				}	
			}
		}else{
			click(element);
		}
	}
	
	void perform_click(LinkedHashMap<String,String> mapobjlist, int index){
		WebElement final_xpath_obj = null ;

		if(mapobjlist.size()>1){
			System.out.println("Multiple html structure are present on page for same object.. function may not work... please specify specific index");
		}
		int rs = 0;
		//execute with true
		for (Map.Entry<String, String> entry : mapobjlist.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			if(value.equalsIgnoreCase("true")){
				System.out.println("execute with true key "+key+" value "+value);
				List<WebElement> elements = sdriver.findElements(By.xpath(key));
				if(elements.size()>1){
					System.out.println("element size "+elements.size());
					System.out.println("Multiple objects are present on the page with the same object property..");
				}
				if(index==0){
					rs = 1;
					index_ex_cond(key);
					break;
				}else{
					rs = 1;
					final_xpath_obj = elements.get(0);
					sf_click_condition(final_xpath_obj);
					break;
				}
			}
		}
		if(rs!=1){
			System.out.println("all objects have click issue.. now clikcing using Javascript on first object..");
			for (Map.Entry<String, String> entry : mapobjlist.entrySet()) {
				System.out.println("false value size "+mapobjlist.size());
				String key = entry.getKey();
				String value = entry.getValue();
				System.out.println("key "+key+" value "+value);
				if(value.equalsIgnoreCase("false")){
					System.out.println("under false condition");
					List<WebElement> elements = sdriver.findElements(By.xpath(key));
					if(index==0){
						index_ex_cond(key);
						break;
					}else{
						final_xpath_obj = elements.get(0);
						sf_click_condition(final_xpath_obj);
						break;
					}
				}
			}
		}
	}
	
	private void index_ex_cond(String key){
		System.out.println("under click all condition.. will peform click on all present object..");
		String new_xp = key.substring(1, key.length()-4);
		System.out.println("final xpath :: "+new_xp);
		List<WebElement> elem = return_WebElements(new_xp);
		System.out.println("Total object size "+elem.size());
		for(int i=0; i<elem.size(); i++){
			WebElement element = elem.get(i);
			try{
				System.out.println("clicked on "+i+" index");
				sf_click_condition(element);
				staticwait(3);
			}catch(Exception e){}
		}
	}
	
	protected String return_xpath_input(ArrayList<String> objectList1, int arr_index){
		String final_xpath_obj = null ;
		ArrayList<String> objectList2 = new ArrayList<String> ();
		int rs = 0;
		System.out.println("present element size "+objectList1.size());
		for(int i=0; i<objectList1.size(); i++){
			String xpath_obj = objectList1.get(i);
			List<WebElement> elements = sdriver.findElements(By.xpath(xpath_obj));
			if(elements.size()>0 && elements.size()<2){
				rs = 1;
				System.out.println("Element found "+xpath_obj);
				try{
					wait_for_element_to_present(By.xpath(xpath_obj), 50);
					objectList2.add(xpath_obj);
				}catch(Exception e){e.getMessage();}
			}else if(elements.size()>1){
				System.out.println("element size "+elements.size());
				System.out.println("Multiple objects are present on the page with the same object property..");
			}
		}
		//3rd process check..
		System.out.println("objectList2 size 3rd process "+objectList2.size());
		for(int j=0; j<objectList2.size(); j++){
			String xpath_obj = objectList1.get(j);
			try{
				WebElement element = return_Webelement(xpath_obj);
				enter(element, "0");
				final_xpath_obj = xpath_obj;
				System.out.println("set to element");
				break;
			}catch(ElementClickInterceptedException b){
				System.out.println("return_xpath_enter_textfield ElementClickInterceptedException exception occured..");
//				b.printStackTrace();
			}catch(TimeoutException b){
				System.out.println("return_xpath_enter_textfield TimeoutException exception occured..");
//				b.printStackTrace();
			}catch(ElementNotInteractableException e){
				System.out.println("return_xpath_enter_textfield ElementNotInteractableException exception occured..");
//				e.printStackTrace();
				final_xpath_obj = xpath_obj;
				System.out.println("set to element");
				break;
			}catch(InvalidElementStateException e){
				System.out.println("InvalidElementStateException occured.. exception handled.. "+e.getMessage());
				WebElement element = return_Webelement(xpath_obj);
				click(element);
				staticwait(2);
				enter(element, "0");
				final_xpath_obj = xpath_obj;
				System.out.println("set to element");
				break;
			}
		}
		if(rs!=1){
			System.out.println("Element not found ");
		}
		return final_xpath_obj;
	}
	
	protected void enter_condition(String xpath_obj, String text, int index){
		if(index==0){
			System.out.println("under click all condition");
			String new_xp = xpath_obj.substring(1, xpath_obj.length()-4);
			System.out.println("final xpath :: "+new_xp);
			List<WebElement> elem = return_WebElements(new_xp);
			for(int i=0; i<elem.size(); i++){
				WebElement element = elem.get(i);
				try{
					System.out.println("clicked on "+i+" index");
					enter(element, text);	
					staticwait(3);
				}catch(Exception e){}
			}
		}else{
			System.out.println("clicked on "+xpath_obj);
			WebElement element = return_Webelement(xpath_obj);
			staticwait(2);
			enter(element, text);
		}
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
	
	public void handle_dropdown(LinkedHashMap<String,String> object_list,int html_ind, String value){
		int check = 0;
		System.out.println("object_list size "+object_list.size());

		check_multiple_obj(object_list);
		
		if(html_ind!=0){
			System.out.println("adding value based on index ------ ");
			int i=0;
			LinkedHashMap<String,String> index_based =  new LinkedHashMap<String, String>();
			for (Map.Entry<String, String> m : object_list.entrySet()) {
				if(i==html_ind){
					String key_ob = m.getKey();
					String Key_vl = m.getValue();
					System.out.println("key object "+key_ob + " " + Key_vl+" index "+i);
					index_based.put(key_ob, Key_vl);
				}
				i++;
			}
			System.out.println("under index execution..");
			for (Map.Entry<String, String> m : index_based.entrySet()) {
				String key_ob = m.getKey();
				String Key_vl = m.getValue();
				System.out.println("index key object "+key_ob + " " + Key_vl);
				List<WebElement> elements = return_WebElements(key_ob);
				
				if(elements.size()>=2){
					System.out.println("Multiple objects are present for same label.. or xpath... please check...");
					System.out.println("xpath "+key_ob);
				}
				
				if(elements.size()>0){
					System.out.println("element found "+key_ob+Key_vl);
					check = 1;
					WebElement click_obj = return_Webelement(key_ob);
					sf__handle_dropdown_(click_obj,key_ob+Key_vl,value);
					break;
				}else{
					System.out.println("still looking for the object.. please wait..");
				}
			}
		}else{
			for (Map.Entry<String, String> m : object_list.entrySet()) {
				String key_ob = m.getKey();
				String Key_vl = m.getValue();
				System.out.println("key object "+key_ob + " " + Key_vl);
				List<WebElement> elements = return_WebElements(key_ob);
				if(elements.size()>0){
					System.out.println("element found "+key_ob+Key_vl);
					check = 1;
					WebElement click_obj = return_Webelement(key_ob);
					sf__handle_dropdown_(click_obj,key_ob+Key_vl,value);
					break;
				}else{
					System.out.println("still looking for the object.. please wait..");
				}
			}
		}

		if (check==0){
			System.out.println("lightning drop down object not found..");
		}
		
	}
	
	public void sf__handle_dropdown_(WebElement element_click, String _dropdown_option_xpath,String value){
		click(element_click);
		staticwait(5);
		List<WebElement> list_element = sdriver.findElements(By.xpath(_dropdown_option_xpath));
		int matchrs = 0;
		for(int i=0; i<list_element.size(); i++){
			WebElement obj = list_element.get(i);
			String option_vl = obj.getText();
			String option_vl2 = obj.getAttribute("innerText");
			System.out.println("option value "+option_vl+"  option value 2 "+option_vl2);
			if(option_vl.equals(value) || option_vl2.equals(value)){
				matchrs = 1;
				System.out.println("option value "+option_vl+" matched with expected value "+value);
				System.out.println("option value "+option_vl2+" matched with expected value "+value);
				click(obj);
				break;
			}
		}
		if(matchrs!=1){
			System.out.println(value+" not found in drop down list");
		}
	}
	
}
