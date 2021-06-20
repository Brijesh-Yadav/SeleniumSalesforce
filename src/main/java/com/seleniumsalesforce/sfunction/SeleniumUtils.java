package com.seleniumsalesforce.sfunction;

import java.awt.AWTException;
import java.awt.Robot;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils{
	
	public static void main(String []args){
		System.out.println(__get_future_date_("dd MMM yyyy",0, 5));
	}
	
	public static String __get_current_date_time() {
		String date_time = null;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd HHmmss");
		LocalDateTime now = LocalDateTime.now();
		date_time = dtf.format(now);
		return date_time;
	}
	
	public boolean __js_isreadonly(WebDriver driver, WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean disabled = (Boolean) js.executeScript("return arguments[0].hasAttribute(\"readOnly\");", element);
		return disabled;
	}
	
	public void __js_enter_chr_by_chr(WebDriver driver, WebElement srchField, String srchString) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", srchField);

		for (int i = 0; i < srchString.length(); i++) {
			try {
				Thread.sleep(300);
			} catch (InterruptedException e){}			
			char c = srchString.charAt(i);
			String s = new StringBuilder().append(c).toString();
			srchField.sendKeys(s);
		}
	}
	
	public static String __get_date_time_customizedformat(String date_timeformat) {
		//"yyyyMMdd HHmmss"
		//dd MMM yyyy HHmmss
		String date_time = null;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(date_timeformat);
		LocalDateTime now = LocalDateTime.now();
		date_time = dtf.format(now);
		return date_time;
	}
	
	public static String __get_date_customizedformat(String date_timeformat) {
		//"yyyyMMdd HHmmss"
		//dd MMM yyyy
		String date_time = null;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(date_timeformat);
		LocalDateTime now = LocalDateTime.now();
		date_time = dtf.format(now);
		return date_time;
	}
	
	public static String __get_future_date_(String format, int momth, int days) {
		//"yyyyMMdd HHmmss"
		//dd MMM yyyy
		String date_ = null;
		Calendar cal = Calendar.getInstance();
	    System.out.println("Current date : " + (cal.get(Calendar.MONTH) + momth) + "-"
	        + cal.get(Calendar.DATE) + "-" + cal.get(Calendar.YEAR));

	    // add month and days to current date using Calendar.add method
	    cal.add(Calendar.MONTH, momth);
	    cal.add(Calendar.DATE, days);
	    
	    System.out.println("date after adding "+momth+" month : and "+days+" : " + (cal.get(Calendar.MONTH) ) + "-"
	        + cal.get(Calendar.DATE) + "-" + cal.get(Calendar.YEAR));
	    
	    Date date = cal.getTime();             
	    SimpleDateFormat format1 = new SimpleDateFormat(format);
	    date_ = format1.format(date); 
		return date_;
	}
	
	public void __click(WebDriver driver, WebElement element){
		try{
			__waitForelement_clickable(driver, element, 15);
			element.click();
			System.out.println("clicked on element via normal click");
		}catch(JavascriptException e){
			System.out.println("JavascriptException __click "+e.getMessage());
			System.out.println("exception handled..");
			__staticWait(3);
			__js_click(driver, element);
		}catch(ElementClickInterceptedException e){
			System.out.println("ElementClickInterceptedException __click "+e.getMessage());
			System.out.println("exception handled..");
			System.out.println("clicked viaa javascript ..");
			__staticWait(3);
			__js_click(driver, element);
		}catch(ElementNotInteractableException e){
			System.out.println("ElementNotInteractableException __click "+e.getMessage());
			System.out.println("exception handled..");
			System.out.println("clicked viaa javascript ..");
			__staticWait(3);
			__js_click(driver, element);
		}catch(StaleElementReferenceException e){
			System.out.println("StaleElementReferenceException __click "+e.getMessage());
			System.out.println("exception handled..");
			System.out.println("clicked viaa javascript ..");
			__staticWait(3);
			__js_click(driver, element);
		}catch(Exception e){
			System.out.println("Exception __click "+e.getMessage());
			e.printStackTrace();
//			Assert.fail("Element not found.. "+e.getMessage());
		}
	}
	
	public boolean __js_isDisabled(WebDriver driver, WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		boolean disabled = (Boolean) js.executeScript("return arguments[0].hasAttribute(\"disabled\");", element);
		return disabled;
	}
	
	public void __clear(WebElement element){
		element.clear();
	}
	
	public void __swich_back_to_default(WebDriver driver){
		driver.switchTo().defaultContent();
	}
	
	public void __select_value_from_dropdown(WebDriver driver, WebElement element, String value){
		Select select = new Select(element);
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		System.out.println("default selected item "+defaultItem);
		if(defaultItem.trim().equalsIgnoreCase(value.trim())){
			System.out.println(value+" is already selected");
		}else{
			select.selectByVisibleText(value.trim());
			System.out.println(value+" is selected");
		}
	}

	public void __js_wait_to_load_HTML_Page(WebDriver driver, int time) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Initially bellow given if condition will check ready state of page.
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			System.out.println("Page Is loaded..");
			return;
		}
		//wait for given time to load html page
		for (int i = 0; i < time; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("wait.. for page to load.. "+i+" sec..");
			} catch (InterruptedException e) {
			}
			// To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				System.out.println("Page Is loaded.");
				break;
			}
		}
	}
	
	public void __enter(WebElement element, String text){
		element.clear();
		element.sendKeys(text);
		System.out.println(text+ " text is entered");
	}
	
	public void __enter(WebDriver driver, WebElement element, String text){
		try{
			element.clear();
			element.sendKeys(text);
			System.out.println(text+ " text is entered");
		}catch(ElementClickInterceptedException e){
			System.out.println("ElementClickInterceptedException occured.. exception handled.. "+e.getMessage());
			__click(driver, element);
			element.clear();
			element.sendKeys(text);
			System.out.println(text+ " text is entered");
		}catch(InvalidElementStateException e){
			System.out.println("InvalidElementStateException occured.. exception handled.. "+e.getMessage());
			__click(driver, element);
			element.clear();
			element.sendKeys(text);
			System.out.println(text+ " text is entered");
		}
	}
	
	public void __js_click(WebDriver driver,WebElement element){
		try{
			JavascriptExecutor jsobj = (JavascriptExecutor)driver;
			jsobj.executeScript("arguments[0].click();", element);
			System.out.println("clicked on element using javascript");
		}catch(Exception e){
			System.out.println("js_click error "+e.getMessage());
		}
	}
	
	public void __waitForelement_clickable(WebDriver driver,WebElement element, int time){
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		System.out.println("element is present now.");
	}
	
	public boolean __Is_clickable(WebElement element){
		boolean ele_prs = false;
		if(element.isDisplayed()==true && element.isEnabled()==true){
			ele_prs = true;
		}
		return ele_prs;
	}
	
	public void __waitForElementToBeClickable(WebDriver driver,int time,String string_xpath){
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(string_xpath)));
		System.out.println("element is present now.");
	}
	
	public void __waitForelement_presence(WebDriver driver,WebElement element, int time){
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		System.out.println("element is present now.");
	}
	
	public void __waitForelement_not_presence(WebDriver driver,WebElement element, int time){
		__staticWait(2);
		for(int i=1; i<=time; i++){
			try{
			 boolean result = element.isDisplayed();
			 if(result==true){
				 System.out.println("waiting for element to disappeaer..");
				 __staticWait(1);
			 }else{
				 System.out.println("element is not present now.");
				 return;
			 }
			}catch(Exception e){
				System.out.println("element is not present now.");
				return;
			}
		}
	}
	
	
	public void __waitForelement_presence(WebDriver driver,By by, int time){
		WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		System.out.println("element is present now.");
	}
	
	public boolean __is_elementPresence(WebElement element){
		boolean presence = element.isDisplayed();
		if(presence==true){
			System.out.println("element present");
		}else{
			System.out.println("element is not present");
//			Assert.fail(element+" element is not present");
			return false;
		}
		return true;
	}

	
	public boolean __is_elementPresence(List<WebElement> element){
		if(element.size()>0){
			System.out.println("element present");
		}else{
			System.out.println("element is not present");
			return false;
//			Assert.fail(element+" element is not present");
		}
		return true;
	}
	
	public WebElement __return_WebElement(WebDriver driver,String xpath_obj){
		WebElement element = driver.findElement(By.xpath(xpath_obj));
		return element;
	}

	public List<WebElement> __return_WebElements(WebDriver driver,String xpath_obj){
		List<WebElement> element_list = driver.findElements(By.xpath(xpath_obj));
		return element_list;
	}

	
	public void __staticWait(int time){
		System.out.println("total wait time "+time+" sec");
		try{
			for(int i=0; i<=time; i++){
				System.out.println("waiting.."+i+" sec");
				Thread.sleep(1000);
			}
		}catch(Exception e){
			System.out.println("__staticWait - ignore messages ");
		}
	}
	
	public void  __compare_String(String keyword, String actual, String expected) {
		switch (keyword) {
		case "equal":
			System.out.println("equal comparison");
			if (actual.equals(expected)) {
				System.out.println(actual+" and "+expected+" are equal");
			}else{
				System.out.println(actual+" and "+expected+" are not equal");
//				Assert.fail(actual+" and "+expected+" are not equal");
			}
			break;
		case "not equal":
			System.out.println("not equal comparison");
			if (!actual.equals(expected)) {
				System.out.println(actual+" and "+expected+" are not equal");
			}else{
				System.out.println(actual+" and "+expected+" are equal");
//				Assert.fail(actual+" and "+expected+" are equal");
			}
			break;
		case "contains":
			System.out.println("contains comparison");
			if (actual.contains(expected)) {
				System.out.println(actual+" contains "+expected+" value");
			}else{
				System.out.println(actual+" does not contains "+expected+" value");
//				Assert.fail(actual+" does not contains "+expected+" value");
			}
			break;
		default:
			System.out.println("keywod does not exist!!");
		}
	}
	
	public void  __compare_integer(String keyword, int actual, int expected) {
		switch (keyword) {
		case "equal":
			System.out.println("equal comparison");
			if (actual==expected) {
				System.out.println(actual+" and "+expected+" are equal");
			}else{
				System.out.println(actual+" and "+expected+" are not equal");
//				Assert.fail(actual+" and "+expected+" are not equal");
			}
			break;
		case "not equal":
			System.out.println("not equal comparison");
			if (actual!=expected) {
				System.out.println(actual+" and "+expected+" are not equal");
			}else{
				System.out.println(actual+" and "+expected+" are equal");
//				Assert.fail(actual+" and "+expected+" are equal");
			}
			break;
		default:
			System.out.println("keywod does not exist!!");
		}
	}
	
	public int __get_RandomNumber(){
		 Random random = new Random();
		    return random.ints(10000, 999999)
		      .findFirst()
		      .getAsInt();
	}
	
	public void __press_key_selenium(WebElement element, Keys key){
		element.sendKeys(key);
	}
	
	public void __press_KeyBoardkey(int vkEnter){
		try {
			//key codes
			//https://docstore.mik.ua/orelly/webprog/DHTML_javascript/0596004672_jvdhtmlckbk-app-b.html
			//key.Event.VK_Enter
			Robot robot = new Robot();
			robot.keyPress(vkEnter);
			robot.keyRelease(vkEnter);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public void __js_enter(WebDriver driver,WebElement element, String text){
		try{
			JavascriptExecutor jsobj = (JavascriptExecutor)driver;
			jsobj.executeScript("arguments[0].innerHTML= '"+text+"'", element);
		}catch(Exception e){
			System.out.println("__js_enter error "+e.getMessage());
		}
	}
	
	
	public void __mouse_click(WebDriver driver,WebElement element){
		try{
			Actions builder = new Actions(driver);
            Action mouseOverHome = builder.moveToElement(element).click().build();
            mouseOverHome.perform();        
		}catch(Exception e){
			System.out.println("__mouse_click error "+e.getMessage());
		}
	}
	
	public void __js_setAttribute(WebDriver driver,WebElement element, String attName, String attValue){
		try{
			JavascriptExecutor jsobj = (JavascriptExecutor)driver;
			jsobj.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", 
	                element, attName, attValue);
		}catch(Exception e){
			System.out.println("__js_setAttribute error "+e.getMessage());
		}
	}
	
	public String __get_text(WebElement element){
		String text =  element.getText();
		return text;
	}
	
	public int __get_url_request_responseCode(String request_url) {
		int r = 0 ;
		try {
			HttpURLConnection c = (HttpURLConnection)new URL(request_url)
					.openConnection();
			// set the HEAD request with setRequestMethod
			c.setRequestMethod("HEAD");
			// connection started and get response code
			c.connect();
			r = c.getResponseCode();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return r;
	}
	
	private int arraySortedOrNot(int arr[], int n) {
		// Array has one or no element or the
		// rest are already checked and approved.
		if (n == 1 || n == 0)
			return 1;
		// Unsorted pair found (Equal values allowed)
		if (arr[n - 1] < arr[n - 2])
			return 0;
		// Last pair was sorted
		// Keep on checking
		return arraySortedOrNot(arr, n - 1);
	}
	
	public void __check_sortedOrNot(ArrayList<Integer> list) {
		Object[] obj = list.toArray();
		int arr [] = new int[obj.length];
		 // copy elements from object array to string array
        for (int i = 0; i < obj.length; i++){
        	arr[i] =  (Integer) obj[i];
        }
		int n = arr.length;
		System.out.println("arr "+arr[0]+" "+arr[1]+" "+arr[2]);
		if (arraySortedOrNot(arr, n) != 0)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
	
	public boolean __Is_Ascending(ArrayList<Integer> list){
		Object[] obj = list.toArray();
		int data [] = new int[obj.length];
		 // copy elements from object array to string array
        for (int i = 0; i < obj.length; i++){
        	data[i] = (Integer) obj[i];
        }
		for (int i = 0; i < data.length-1; i++) {
		    if (data[i] > data[i+1]) {
		        return false;
		    }
		}
		return true;
	}
	
	public boolean __Is_Descending(ArrayList<Integer> list){
		Object[] obj = list.toArray();
		int data [] = new int[obj.length];
		 // copy elements from object array to string array
        for (int i = 0; i < obj.length; i++){
        	data[i] = (Integer) obj[i];
        }
		for (int i = 0; i < data.length-1; i++) {
		    if (data[i] < data[i+1]) {
		        return false;
		    }
		}
		return true;
	}
	
	public void __compare_boolean(boolean expected, boolean actual) {
		if (expected == actual) {
			System.out.println(actual + " is equal to " + expected + " value");
		} else {
			System.out.println(actual + " is not equal to " + expected + " value");
//			Assert.fail(actual + " is not equal to " + expected + " value");
		}
	}

	public boolean __checkSorting_string(ArrayList<String> arraylist) {
		boolean isSorted = true;
		for (int i = 1; i < arraylist.size(); i++) {
			if (arraylist.get(i - 1).compareTo(arraylist.get(i)) > 0) {
				isSorted = false;
				break;
			}
		}
		return isSorted;
	}
	
	public boolean __issortDateTimeText(ArrayList<String> dateStrList, String sorting) {
		boolean result = false;
/*		List<String> dateStrList = new ArrayList<String>();
		// MM/dd/yyyy '@'hh:mm a
		dateStrList.add("01-21/2014 @03:13 PM");
		dateStrList.add("01-21/2011 @04:37 PM");
		dateStrList.add("01-21/2012 @10:41 AM");
		dateStrList.add("01-21/2013 @10:48 AM");
		dateStrList.add("01-22/2015 @06:16 AM");
		dateStrList.add("01-22/2013 @06:19 AM");
		dateStrList.add("01-21/2018 @05:19 PM");
		dateStrList.add("01-21/2013 @05:19 PM");
		
		dateStrList.add("21-Mar-2014 03:13 pm");
		dateStrList.add("21-Mar-2011 04:37 pm");
		dateStrList.add("21-Mar-2012 10:41 am");
		dateStrList.add("21-Mar-2013 10:48 am");
		dateStrList.add("22-Mar-2015 06:16 am");
		dateStrList.add("22-Mar-2013 06:19 am");
		dateStrList.add("21-Mar-2018 05:19 pm");
		dateStrList.add("21-Mar-2013 05:19 pm");*/

		System.out.println("---> Date & Time List Before Sort (Mon/dd/yyyy '@'hh:mm a)");
		for (String dateStr : dateStrList)
			System.out.println(dateStr);
		// Sort String Date
		Collections.sort(dateStrList, new Comparator<String>() {
			//"MM/dd/yyyy '@'hh:mm a"
			DateFormat f = new SimpleDateFormat("dd-MMM-yyyy hh:mm a");

			public int compare(String o1, String o2) {
				try {
					return f.parse(o1).compareTo(f.parse(o2));
				} catch (ParseException e) {
					throw new IllegalArgumentException(e);
				}
			}
		});
		if (sorting.equalsIgnoreCase("sort")) {
			System.out.println("---> Date & Time List After Sort (MM/dd/yyyy '@'hh:mm a)");
			ArrayList<String> arrlst = new ArrayList<String>();
			for (String dateStr : dateStrList) {
				System.out.println(dateStr);
				arrlst.add(dateStr);
			}
			if(arrlst.equals(dateStrList)){
				result =true;
			}
		} else {
			System.out.println("---> Date & Time List After revese (MM/dd/yyyy '@'hh:mm a)");
			Collections.reverse(dateStrList);
			ArrayList<String> arrlst = new ArrayList<String>();
			for (String dateStr : dateStrList) {
				System.out.println(dateStr);
				arrlst.add(dateStr);
			}
			if(arrlst.equals(dateStrList)){
				result =true;
			}
		}
		return result;
	}
	
	public void __wait_for_present_to_element_arraylist(WebDriver driver,ArrayList<String> arraylist, int time){
		for(int i=0; i<arraylist.size(); i++){
			String xpath_obj = arraylist.get(i);
			int res = 0;
			for(int j=1; j<=time; j++){
				List<WebElement> elesize = __return_WebElements(driver, xpath_obj);
				if(elesize.size()>0){
					res = 1;
					System.out.println(xpath_obj+" element is present");
					break;
				}else{
					__staticWait(1);
					System.out.println("waiting for element to present.."+j+" sec");
				}
			}
			if(res!=1){
				System.out.println(xpath_obj+" element is not found..");
			}
		}
	}
	
	public void __wait_for_present_to_element(WebDriver driver,String xpath, int time){
		int res = 0;
		for(int j=1; j<=time; j++){
			List<WebElement> element = __return_WebElements(driver, xpath);
			if(element.size()>0){
				res = 1;
				System.out.println(" element is present");
				break;
			}else{
				__staticWait(1);
				System.out.println("waiting for element to present.."+j+" sec");
			}
		}
		if(res!=1){
			System.out.println(" element is not found..");
		}
	}
	
	
}
