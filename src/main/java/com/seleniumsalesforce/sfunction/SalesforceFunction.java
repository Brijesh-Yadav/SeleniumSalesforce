package com.seleniumsalesforce.sfunction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SalesforceFunction extends SeleniumUtils{
	
	private WebDriver driver;
	
	public SalesforceFunction(WebDriver driver){
		this.driver=driver;
	}
	
	private ArrayList<String> store_click_object(String object_name, int index){
		ArrayList<String> arraylist = new ArrayList<String>();
		return arraylist;
	}
	

	private ArrayList<String> store_textfield_object(String object_name, int index){
		ArrayList<String> arraylist = new ArrayList<String>();

		return arraylist;
	}
	
	private ArrayList<String> store_wait_object(String object_name, String object_type,int index){
		ArrayList<String> arraylist = new ArrayList<String>();
		if(object_type.equalsIgnoreCase("link")){
			arraylist.add("(//*[text()=\""+object_name+"\"]/ancestor::a[1])["+index+"]");
			arraylist.add("(//ul/li/a[text()=\""+object_name+"\"])["+index+"]");
			arraylist.add("(//a[text()=\""+object_name+"\"])["+index+"]");
			//new added for I2P Project
			arraylist.add("(//a[text()=\""+object_name+"\"])["+index+"]");				
		}else if(object_type.equalsIgnoreCase("button")){
			arraylist.add("(//*[text()=\""+object_name+"\"]/ancestor::button)["+index+"]");
			arraylist.add("(//button[text()=\""+object_name+"\"])["+index+"] | (//button[@title=\""+object_name+"\"])["+index+"]");

		}else if(object_type.equalsIgnoreCase("input")){
			arraylist.add("(//span[text()=\""+object_name+"\"]/ancestor::div[1]//input)["+index+"]");
			arraylist.add("//label[text()=\""+object_name+"\"]/../div//input["+index+"]");
			arraylist.add("(//input[@title=\""+object_name+"\"])["+index+"]");
			arraylist.add("(//input[@name=\""+object_name+"\"])["+index+"] | (//span[text()=\""+object_name+"\"]/ancestor::div[1]//input)["+index+"]");
			arraylist.add("(//span[text()=\""+object_name+"\"]/ancestor::label[1]//input)["+index+"]");	
			
		}else if(object_type.equalsIgnoreCase("textarea")){
			arraylist.add("(//span[text()=\""+object_name+"\"]/ancestor::lightning-textarea[1]/div/textarea)["+index+"]");
			arraylist.add("(//label[text()=\""+object_name+"\"]/../div//textarea)["+index+"]");
			
		}else if(object_type.equalsIgnoreCase("text")){
			
		}else{
			System.out.println("object type does not exist");
		}
		return arraylist;
	}
	
	/**@author - Brijesh Yadav
	 * @description -
	 * @createdOn  - 6 May 2021
	 * @modifiedOn -
	 */
	public void sf__navigate_to_app(WebDriver driver, String app_name){
		__staticWait(9);
		WebElement slide_icon_oj = __return_WebElement(driver, "//div[@class='slds-icon-waffle']");
		__waitForelement_clickable(driver,slide_icon_oj, 90);
		__click(driver,slide_icon_oj);
		__staticWait(5);
		__wait_for_present_to_element(driver,"//input[@placeholder='Search apps and items...']", 90);
		WebElement search_fieldObj = __return_WebElement(driver, "//input[@placeholder='Search apps and items...']");
		__enter(search_fieldObj, app_name);
		__staticWait(5);
		String xpath_obj = "//b[text()='"+app_name+"']/ancestor::a[1]";
		WebElement element = __return_WebElement(driver, xpath_obj);
		__waitForelement_clickable(driver, element, 90);
		__click(driver, element);
		__staticWait(7);
		System.out.println("navigated to app "+app_name);
	}
	
	/**@author - Brijesh Yadav
	 * @description -
	 * @createdOn  - 
	 * @modifiedOn -
	 */
	public void sf__SelectTab_Object(String object_name){
		__staticWait(10);
		String xpath_obj1 = "//one-app-nav-bar-item-root/a[@title=\""+object_name+"\"]";
		__waitForelement_presence(driver, By.xpath(xpath_obj1), 90);
		__waitForElementToBeClickable(driver, 90, xpath_obj1);
		List<WebElement> element = driver.findElements(By.xpath(xpath_obj1));
		System.out.println("__SelectTab_Object xpath_obj1 "+xpath_obj1);
		System.out.println("__SelectTab_Object element size "+element.size());
		if(element.size()>0){
			__click(driver,element.get(0));
			System.out.println("clicked on tab "+object_name);
		}else{
			System.out.println("trying with show more..  "+object_name);
			String xpath_obj2 = "//span[text()='More']/ancestor::a[1]";
			__click(driver,driver.findElement(By.xpath(xpath_obj2)));
			System.out.println("clicked on Show more");
			__click(driver,driver.findElement(By.xpath("//div[@role='menu']//span[text()='"+object_name+"']/ancestor::a[1]")));
			System.out.println("clicked on tab "+object_name+" under more menu");
		}
	}
	
	/**@author - Brijesh Yadav
	 * @description -
	 * @createdOn  - 
	 * @modifiedOn -
	 */
	public void sf__click(String label_name,int index){
		ArrayList<String> arraylist = store_click_object(label_name,index);
		handle_click(arraylist,0,"false");
	}
	
	public void sf__click(String label_name){
		ArrayList<String> arraylist = store_click_object(label_name,1);
		handle_click(arraylist,0,"false");
	}
	
	public void sf__click(String label_name, int arrindex, int obj_index){
		ArrayList<String> arraylist = store_click_object(label_name,obj_index);
		handle_click(arraylist,arrindex,"false");
	}

	
	public void sf__click(String label_name, int arrindex, int obj_index, String all_obj){
		ArrayList<String> arraylist = store_click_object(label_name,obj_index);
		handle_click(arraylist,arrindex,all_obj);
	}

	
	private void sf_click_condition(WebElement element){
		String tagname = element.getTagName();
		System.out.println("sf__click tagname "+tagname);
		if("button".equalsIgnoreCase(tagname)){
			for(int i=1; i<15; i++){
				boolean st = __js_isDisabled(driver, element);
				if(st==false){
					System.out.println("button is enabled..");
					__click(driver, element);
					break;
				}else{
					System.out.println("button is disabled.. waiting to button get enabled..");
					__staticWait(1);
				}	
			}
		}else{
			__click(driver, element);
		}
	}
	


	private ArrayList<String> store_verify_element(String object_name, int index){
		ArrayList<String> arraylist = new ArrayList<String>();
		arraylist.add("(//label/span[text()=\""+object_name+"\"])["+index+"]");
		arraylist.add("(//*[contains(text(),\""+object_name+"\")])["+index+"]");
		return arraylist;
	}

	private ArrayList<String> store_verify_element_label_txt(String object_name,String value, int index){
		ArrayList<String> arraylist = new ArrayList<String>();
		//will work to check like owner name, account name etc...
		arraylist.add("(//*[text()=\""+object_name+"\"])["+index+"]/../following-sibling::div[1]//*[text()=\""+value+"\"]");
		arraylist.add("(//*[contains(text(),\""+object_name+"\")])["+index+"]");
		return arraylist;
	}

	public void sf__verify_element(String object_name,int index){
		ArrayList<String> arraylist = store_verify_element(object_name,index);
		WebElement element = return_xpath(arraylist,0);
		__is_elementPresence(element);
	}

	public void sf__verify_label_value_txt_element(String object_name,String value,int index){
		ArrayList<String> arraylist = store_verify_element_label_txt(object_name,value, index);
		WebElement element = return_xpath(arraylist,0);
		__is_elementPresence(element);
	}

	
	public void sf__enter_textfield(String label, String text, int index){
		ArrayList<String> arraylist = store_textfield_object(label,index);
		String xpath = return_xpath_enter_textfield(arraylist,0);
		enter_condition(xpath,text,"false");
	}
	
	public void sf__enter_textfield(String label, String text, int arr_index, int obj_index){
		ArrayList<String> arraylist = store_textfield_object(label,obj_index);
		String xpath = return_xpath_enter_textfield(arraylist,arr_index);
		enter_condition(xpath,text,"false");
	}
	
	public void sf__enter_textfield(String label, String text, int arr_index, int obj_index, String _all_objs){
		ArrayList<String> arraylist = store_textfield_object(label,obj_index);
		String xpath = return_xpath_enter_textfield(arraylist,arr_index);
		enter_condition(xpath,text,_all_objs);
	}
	
	private void enter_condition(String xpath_obj, String text, String _all_objs){
		if(_all_objs.equalsIgnoreCase("true")){
			System.out.println("under click all condition");
			String new_xp = xpath_obj.substring(1, xpath_obj.length()-4);
			System.out.println("final xpath :: "+new_xp);
			List<WebElement> elem = __return_WebElements(driver, new_xp);
			for(int i=0; i<elem.size(); i++){
				WebElement element = elem.get(i);
				try{
					System.out.println("clicked on "+i+" index");
					__enter(driver,element, text);	
					__staticWait(3);
				}catch(Exception e){}
			}
		}else{
			System.out.println("clicked on "+xpath_obj);
			WebElement element = __return_WebElement(driver, xpath_obj);
			__staticWait(2);
			__enter(driver,element, text);
		}
	}

	public void sf__clear_textfield(String label, int obj_index){
		ArrayList<String> arraylist =store_textfield_object(label,obj_index);
		WebElement element = return_xpath(arraylist,0);
		__clear(element);
	}
	
	public void sf__select_value_from_dropdown_via_pressKey(WebElement element,String value){
		__click(driver,element);
		__enter(element, value);
		__staticWait(3);
		__press_key_selenium(element, Keys.ARROW_DOWN);
		__staticWait(1);
		__press_key_selenium(element, Keys.ENTER);
		System.out.println("Value is selected");
	}
	
	public void sf__select_value_from_dropdown_via_pressKey(String label,String value,int arr_index,int obj_index, int loop){
		ArrayList<String> arraylist = store_textfield_object(label,obj_index);
		WebElement element = return_xpath(arraylist,arr_index);
		__click(driver,element);
		__enter(element, value);
		__staticWait(3);
		for(int i=1; i<=loop; i++){
			__press_key_selenium(element, Keys.ARROW_DOWN);
			__staticWait(1);
		}
		__press_key_selenium(element, Keys.ENTER);
		System.out.println("Value is selected");
	}

	public void sf__handle_dropdown_(WebElement element_click, String _dropdown_option_xpath,String value){
		__click(driver,element_click);
		__staticWait(5);
		List<WebElement> list_element = driver.findElements(By.xpath(_dropdown_option_xpath));
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
				__click(driver,obj);
				break;
			}
		}
		if(matchrs!=1){
			System.out.println(value+" not found in drop down list");
		}
	}

	private HashMap<String,String> store_lightning_dropdown_object(String label_name, String value, int index){
		HashMap<String,String> hm = new HashMap<String, String>();
		hm.put("(//lightning-combobox/*[text()=\""+label_name+"\"])["+index+"]","/..//lightning-base-combobox-item");
		hm.put("(//*[text()=\""+label_name+"\"]/ancestor::div[1]/input)["+index+"]","/..//div[@class='address-selection']/div[@class='pl-label']");
		hm.put("(//label[text()=\""+label_name+"\"]/..//input)["+index+"]","/../following-sibling::div[1]//lightning-base-combobox-item");
		return hm;
	}
	
	public void sf__select_value_from_lightning_dropdown(String label_name, String value, int html_index, int index){
		handle_dropdown(label_name,value, html_index, index);
	}
	
	private void handle_dropdown(String label_name, String value, int html_ind, int index){
		int check = 0;
		HashMap<String,String> object_list = store_lightning_dropdown_object(label_name,value, index);
		System.out.println("object_list size "+object_list.size());
		Object[] keys = object_list.keySet().toArray();
		String dt = object_list.get(keys[1]);
		
		System.out.println("first index key "+object_list.get(1)+"  :: value map  ::  "+dt);
		int ind = 0;
		ArrayList<String> list = new ArrayList<String>();
		for (Map.Entry<String, String> m : object_list.entrySet()) {
			String key_ob = m.getKey();
			String Key_vl = m.getValue();
			System.out.println("key object "+key_ob + " " + Key_vl+" index "+ind);
			List<WebElement> listobj = __return_WebElements(driver, key_ob);
			if(listobj.size()>0){
				list.add(key_ob);
			}
			ind++;
		}
		
		if(list.size()>1){
			System.out.println("Multiple html strucute are present.."+list.size()+" please specify index...");
			System.out.println("Function may not work.. if you don't");
		}
		
		System.out.println("adding value based on index");
		
		int i=0;
		HashMap<String,String> index_based =  new HashMap<String, String>();
		for (Map.Entry<String, String> m : object_list.entrySet()) {
			if(i==html_ind){
				String key_ob = m.getKey();
				String Key_vl = m.getValue();
				System.out.println("key object "+key_ob + " " + Key_vl+" index "+ind);
				index_based.put(key_ob, Key_vl);
			}
			i++;
		}
		System.out.println("adding value based on index ------ ");
		
		if(html_ind!=0){
			System.out.println("under index execution..");
			for (Map.Entry<String, String> m : index_based.entrySet()) {
				String key_ob = m.getKey();
				String Key_vl = m.getValue();
				System.out.println("index key object "+key_ob + " " + Key_vl);
				List<WebElement> elements = __return_WebElements(driver, key_ob);
				
				if(elements.size()>=2){
					System.out.println("Multiple objects are present for same label.. or xpath... please check...");
					System.out.println("xpath "+key_ob);
				}
				
				if(elements.size()>0){
					System.out.println("element found "+key_ob+Key_vl);
					check = 1;
					WebElement click_obj = __return_WebElement(driver, key_ob);
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
				List<WebElement> elements = __return_WebElements(driver, key_ob);
				if(elements.size()>0){
					System.out.println("element found "+key_ob+Key_vl);
					check = 1;
					WebElement click_obj = __return_WebElement(driver, key_ob);
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
	
	public void sf__select_value_from_lightning_dropdown(String label_name, String value, int index){

		int check = 0;
		HashMap<String,String> object_list = store_lightning_dropdown_object(label_name,value, index);
		System.out.println("object_list size "+object_list.size());
		Object[] keys = object_list.keySet().toArray();
		String dt = object_list.get(keys[1]);
		
		System.out.println("first index key "+object_list.get(1)+"  :: value map  ::  "+dt);
		int ind = 0;
		for (Map.Entry<String, String> m : object_list.entrySet()) {
			String key_ob = m.getKey();
			String Key_vl = m.getValue();
			System.out.println("key object "+key_ob + " " + Key_vl+" index "+ind);
			ind++;
		}
		
		int html_ind = 0;
		int i=1;
		HashMap<String,String> index_based =  new HashMap<String, String>();
		for (Map.Entry<String, String> m : object_list.entrySet()) {
			if(i==html_ind){
				String key_ob = m.getKey();
				String Key_vl = m.getValue();
				System.out.println("key object "+key_ob + " " + Key_vl+" index "+i);
				index_based.put(key_ob, Key_vl);
			}
			i++;
		}
		for (Map.Entry<String, String> m : object_list.entrySet()) {
			String key_ob = m.getKey();
			String Key_vl = m.getValue();
			System.out.println("key object "+key_ob + " " + Key_vl);
			List<WebElement> elements = __return_WebElements(driver, key_ob);
			if(elements.size()>0){
				System.out.println("element found "+key_ob+Key_vl);
				check = 1;
				WebElement click_obj = __return_WebElement(driver, key_ob);
				sf__handle_dropdown_(click_obj,key_ob+Key_vl,value);
				break;
			}else{
				System.out.println("still looking for the object.. please wait..");
			}
		}
		if (check==0){
			System.out.println("lightning drop down object not found..");
		}
	}
	
	private WebElement return_xpath(ArrayList<String> arraylist, int arr_index){
		WebElement final_xpath_obj = null ;
		//checking multiple objects if its present..
		ArrayList<String> objectList1 = process_object_multiple_check(arraylist,arr_index);
		//2nd process check..
		int rs = 0;
		System.out.println("objectList1 size "+objectList1.size());
		for(int i=0; i<objectList1.size(); i++){
			String xpath_obj = objectList1.get(i);
			List<WebElement> elements = driver.findElements(By.xpath(xpath_obj));
			if(elements.size()>0){
				rs = 1;
				final_xpath_obj = elements.get(0);
				System.out.println("Element found "+xpath_obj);
				try{
					__waitForelement_presence(driver, By.xpath(xpath_obj), 50);
				}catch(Exception e){
				}
				break;
			}
		}
		if(rs!=1){
			System.out.println("Element not found ");
		}
		return final_xpath_obj;
	}
	
	private String return_xpath_enter_textfield(ArrayList<String> arraylist, int arr_index){
		String final_xpath_obj = null ;
		//checking multiple objects if its present..
		ArrayList<String> objectList1 = process_object_multiple_check(arraylist,arr_index);
		ArrayList<String> objectList2 = new ArrayList<String> ();
		//2nd process check..
		int rs = 0;
		System.out.println("objectList1 size "+objectList1.size());
		
		for(int i=0; i<objectList1.size(); i++){
			String xpath_obj = objectList1.get(i);
			List<WebElement> elements = driver.findElements(By.xpath(xpath_obj));
			if(elements.size()>1){
				System.out.println("element size "+elements.size());
				System.out.println("Multiple objects are present on the page with the same object property..");
			}
			if(elements.size()>0){
				rs = 1;
				System.out.println("Element found "+xpath_obj);
				try{
					__waitForelement_presence(driver, By.xpath(xpath_obj), 50);
					objectList2.add(xpath_obj);
				}catch(Exception e){
				}
			}
		}
		//3rd process check..
		System.out.println("objectList2 size 3rd process "+objectList2.size());
		for(int j=0; j<objectList2.size(); j++){
			String xpath_obj = objectList1.get(j);
			try{
				WebElement element = __return_WebElement(driver, xpath_obj);
				__enter(element, "0");
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
				WebElement element = __return_WebElement(driver, xpath_obj);
				__click(driver, element);
				__staticWait(2);
				__enter(element, "0");
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
	
	private void handle_wait(ArrayList<String> objectList1, int arr_index){
		//checking multiple objects if its present..
		//2nd process check..
		System.out.println("objectList1 size "+objectList1.size());
		if(objectList1.size()==1){
			for(int i = 0; i<objectList1.size(); i++){
				String xpath_obj = objectList1.get(i);
				sf__wait_condition(xpath_obj);
			}
		}else if(objectList1.size()>1){
			System.out.println("more than 1 html structure is present.. this function may not work.. or provide the indexing for structure..");
		}
	}
	
	private void handle_click(ArrayList<String> arraylist, int arr_index,String all_obj){
		WebElement final_xpath_obj = null ;
		//checking multiple objects if its present..
		ArrayList<String> objectList1 = process_object_multiple_check(arraylist,arr_index);
		//2nd process check..
		HashMap<String,String> mapobjlist = process_object_evaluation(objectList1);
		if(mapobjlist.size()>1){
			System.out.println("Multiple html structure are present on page for same object.. function may not work... please specify specific index");
		}
		int rs = 0;
		//execute with true
		for (Map.Entry<String, String> entry : mapobjlist.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
//			System.out.println("execute with true key "+key+" value "+value);
			if(value.equalsIgnoreCase("true")){
				System.out.println("execute with true key "+key+" value "+value);
				List<WebElement> elements = driver.findElements(By.xpath(key));
				if(elements.size()>1){
					System.out.println("element size "+elements.size());
					System.out.println("Multiple objects are present on the page with the same object property..");
				}
				if(all_obj.equalsIgnoreCase("true")){
					rs = 1;
					System.out.println("under click all condition");
					String new_xp = key.substring(1, key.length()-4);
					System.out.println("final xpath :: "+new_xp);
					List<WebElement> elem = __return_WebElements(driver, new_xp);
					for(int i=0; i<elem.size(); i++){
						WebElement element = elem.get(i);
						try{
							System.out.println("clicked on "+i+" index");
							sf_click_condition(element);
							__staticWait(3);
						}catch(Exception e){}
					}
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
					List<WebElement> elements = driver.findElements(By.xpath(key));
					if(all_obj.equalsIgnoreCase("true")){
						System.out.println("under click all condition");
						String new_xp = key.substring(1, key.length()-4);
						System.out.println("final xpath :: "+new_xp);
						List<WebElement> elem = __return_WebElements(driver, new_xp);
						System.out.println("Total object size "+elem.size());
						for(int i=0; i<elem.size(); i++){
							WebElement element = elem.get(i);
							try{
								System.out.println("clicked on "+i+" index");
								sf_click_condition(element);
								__staticWait(3);
							}catch(Exception e){}
						}
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
	
	private HashMap<String,String>process_object_evaluation(ArrayList<String> arraylist){
		HashMap<String,String> mapobj = new HashMap<String,String>();
		for(int i=0; i<arraylist.size(); i++){
			String xpath_obj = arraylist.get(i);
			try{
				WebElement element = __return_WebElement(driver, xpath_obj);
//				try{
//					__waitForelement_clickable(driver, element, 5);
//					System.out.println("wait is completed.. and element is present..");
//				}catch(Exception e){}
				boolean result  = __Is_clickable(element);
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
	
	private ArrayList<String> process_object_multiple_check(ArrayList<String> objectlist, int index){
		//print indexing number
		for(int j=0; j<objectlist.size(); j++){
			String xpath_obj = objectlist.get(j);
			System.out.println(xpath_obj+ "  "+"indexing number is :: "+j);
		}
		ArrayList<String> arraylist = new ArrayList<String>();
		if(index!=0){
			String xpath = objectlist.get(index);
			System.out.println("index value is "+xpath);
			arraylist.add(xpath);
		}else{
			System.out.println("\n");
			//find element presence
			for(int i=0; i<objectlist.size(); i++){
				String xpath_obj = objectlist.get(i);
				List<WebElement> eleobj = __return_WebElements(driver, xpath_obj);
				if(eleobj.size()>0){
					System.out.println(xpath_obj+" element is present.. index number is :: "+i);
					arraylist.add(xpath_obj);
				}
			}
			if(arraylist.size()==0){
				System.out.println("arraylist size "+arraylist.size());
			}
			System.out.println("first check is completed");
			if(arraylist.size()>1){
				System.out.println("muliple html strucure pattern are present on the page for the same label text...");
				System.out.println("it's not handled in function.. handle it seprately..");
				System.out.println("try to use indexing from above printed data...");
			}
		}
		return arraylist;
	}
	
	public void sf__spinner_load(int time){
		//div[@class='slds-spinner_container slds-grid']//span[text()='Loading...']
		//div[@class='slds-spinner_container slds-grid slds-hide']//span[text()='Loading...']
		ArrayList<String> arraylist = new ArrayList<String>();
		arraylist.add("//div[@class='slds-spinner_container slds-grid slds-hide']//span[text()='Loading...']");
		__wait_for_present_to_element_arraylist(driver,arraylist,time);
		System.out.println("sf__spinner_load... record is loaded..");
	}	
	
	//this function will not work.. under developement
	public void sf__wait_method(String label, String object_type,int arr_index, int obj_index){
		System.out.println("wait method is called..");
		ArrayList<String> arraylist = store_wait_object(label, object_type, obj_index);
		handle_wait(arraylist,arr_index);
	}
	
	private void sf__wait_condition(String elementxp){
		WebElement element = __return_WebElement(driver, elementxp);
		String tagname = element.getTagName();
		System.out.println("sf_wait_condition tagname "+tagname);
		try{
			if("button".equalsIgnoreCase(tagname)){
				__wait_for_present_to_element(driver, elementxp, 90);
				__waitForelement_clickable(driver, element, 90);
				
			}else if("input".equalsIgnoreCase(tagname)){
				__wait_for_present_to_element(driver, elementxp, 90);
				__waitForelement_clickable(driver, element, 90);
				
			}else if("a".equalsIgnoreCase(tagname)){
				__wait_for_present_to_element(driver, elementxp, 90);
				__waitForelement_clickable(driver, element, 90);
				
			}else if("textarea".equalsIgnoreCase(tagname)){
				__wait_for_present_to_element(driver, elementxp, 90);
				__waitForelement_clickable(driver, element, 90);
				
			}else {
				System.out.println("other tag type will be handled with element presence..");
				__wait_for_present_to_element(driver, elementxp, 90);
				__waitForelement_presence(driver, element, 90);
			}
		}catch(Exception e){
			System.out.println("sf_wait_condition exception occured..");
			e.printStackTrace();
		}
	}

}

