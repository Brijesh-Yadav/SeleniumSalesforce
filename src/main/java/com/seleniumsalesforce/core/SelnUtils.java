package com.seleniumsalesforce.core;

import java.awt.AWTException;
import java.awt.Robot;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
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

import com.seleniumsalesforce.core.SoftDriver.SeleniumUtils;

public class SelnUtils implements SeleniumUtils{
	
	private WebDriver w_driver;

	public SelnUtils(WebDriver w_driver) {
		// TODO Auto-generated constructor stub
		this.w_driver = w_driver;
	}

	@Override
	public void click(WebElement element) {
		try{
			wait_for_element_clickable(element, 15);
			element.click();
			System.out.println("clicked on element via normal click");
		}catch(JavascriptException e){
			System.out.println("JavascriptException __click "+e.getMessage());
			System.out.println("exception handled.. clicked with JavaScript");
			staticwait(3);
			js_click(element);
		}catch(ElementClickInterceptedException e){
			System.out.println("ElementClickInterceptedException __click "+e.getMessage());
			System.out.println("exception handled.. clicked with JavaScript");
			staticwait(3);
			js_click(element);
		}catch(ElementNotInteractableException e){
			System.out.println("ElementNotInteractableException __click "+e.getMessage());
			System.out.println("exception handled.. clicked with JavaScript");
			staticwait(3);
			js_click(element);
		}catch(StaleElementReferenceException e){
			System.out.println("StaleElementReferenceException __click "+e.getMessage());
			System.out.println("exception handled.. clicked with JavaScript");
			staticwait(3);
			js_click(element);
		}
	}

	@Override
	public void enter(WebElement element, String text) {
		try{
			element.clear();
			element.sendKeys(text);
			System.out.println(text+ " text is entered");
		}catch(ElementClickInterceptedException e){
			System.out.println("ElementClickInterceptedException occured.. exception handled.. "+e.getMessage());
			click(element);
			element.clear();
			element.sendKeys(text);
			System.out.println(text+ " text is entered");
		}catch(InvalidElementStateException e){
			System.out.println("InvalidElementStateException occured.. exception handled.. "+e.getMessage());
			click(element);
			element.clear();
			element.sendKeys(text);
			System.out.println(text+ " text is entered");
		}
	}

	@Override
	public void staticwait(int time) {
		// TODO Auto-generated method stub
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

	@Override
	public WebElement return_Webelement(String xpath_obj) {
		WebElement element = w_driver.findElement(By.xpath(xpath_obj));
		return element;
	}

	@Override
	public List<WebElement> return_WebElements(String xpath_obj) {
		List<WebElement> element = w_driver.findElements(By.xpath(xpath_obj));
		return element;
	}

	@Override
	public int get_url_request_responseCode(String request_url) {
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

	@Override
	public boolean is_clickable(WebElement element) {
		try{
			if(element.isDisplayed()==true && element.isEnabled()==true){
				return true;
			}else{
				return false;
			}
		}catch(Exception e){
			return false;
		}
	}

	@Override
	public boolean is_element_present(List<WebElement> element) {
		if(element.size()>0){
			System.out.println("element present");
			return true;
		}else{
			System.out.println("element is not present");
			return false;
		}
	}

	@Override
	public void js_click(WebElement element) {
		try{
			JavascriptExecutor jsobj = (JavascriptExecutor)w_driver;
			jsobj.executeScript("arguments[0].click();", element);
			System.out.println("clicked on element using javascript");
		}catch(Exception e){
			System.out.println("js_click error "+e.getMessage());
		}
	}

	@Override
	public void js_enter(WebElement element,String text) {
		try{
			JavascriptExecutor jsobj = (JavascriptExecutor)w_driver;
			jsobj.executeScript("arguments[0].innerHTML= '"+text+"'", element);
		}catch(Exception e){
			System.out.println("__js_enter error "+e.getMessage());
		}
	}

	@Override
	public void js_enter_chr_by_chr(WebElement element, String text) {
		((JavascriptExecutor) w_driver).executeScript("arguments[0].click();", element);
		for (int i = 0; i < text.length(); i++) {
			try {
				Thread.sleep(700);
			} catch (InterruptedException e){}			
			char c = text.charAt(i);
			String s = new StringBuilder().append(c).toString();
			element.sendKeys(s);
		}
	}

	@Override
	public boolean js_is_disabled(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) w_driver;
		boolean disabled = (Boolean) js.executeScript("return arguments[0].hasAttribute(\"disabled\");", element);
		return disabled;
	}

	@Override
	public boolean js_is_readonly(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) w_driver;
		boolean rd = (Boolean) js.executeScript("return arguments[0].hasAttribute(\"readOnly\");", element);
		return rd;
	}

	@Override
	public void js_set_attribute(WebElement element, String attName, String attValue) {
		try{
			JavascriptExecutor jsobj = (JavascriptExecutor)w_driver;
			jsobj.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", 
	                element, attName, attValue);
		}catch(Exception e){
			System.out.println("__js_setAttribute error "+e.getMessage());
		}
	}

	@Override
	public void mouse_click(WebElement element) {
		try{
			Actions builder = new Actions(w_driver);
            Action mouseOverHome = builder.moveToElement(element).click().build();
            mouseOverHome.perform();        
		}catch(Exception e){
			System.out.println("__mouse_click error "+e.getMessage());
		}
	}

	@Override
	public void press_keyboard_button(int vkEnter) {
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

	@Override
	public void press_keyboard_selenium(WebElement element, Keys key) {
		element.sendKeys(key);
	}

	@Override
	public void select_value_from_dropdown( WebElement element,String value) {
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

	@Override
	public void wait_for_element_to_present(String xpath, int waittime) {
		int res = 0;
		for(int j=1; j<=waittime; j++){
			List<WebElement> element = return_WebElements(xpath);
			if(element.size()>0){
				res = 1;
				System.out.println(" element is present");
				break;
			}else{
				staticwait(1);
				System.out.println("waiting for element to present.."+j+" sec");
			}
		}
		if(res!=1){
			System.out.println(" element is not found..");
		}
	}

	@Override
	public void wait_for_element_to_present(ArrayList<String> arraylist, int waittime) {
		for(int i=0; i<arraylist.size(); i++){
			String xpath_obj = arraylist.get(i);
			int res = 0;
			for(int j=1; j<=waittime; j++){
				List<WebElement> elesize = return_WebElements(xpath_obj);
				if(elesize.size()>0){
					res = 1;
					System.out.println(xpath_obj+" element is present");
					break;
				}else{
					staticwait(1);
					System.out.println("waiting for element to present.."+j+" sec");
				}
			}
			if(res!=1){
				System.out.println(xpath_obj+" element is not found..");
			}
		}
	}

	@Override
	public void wait_for_element_clickable(WebElement element, int wait_time) {
		WebDriverWait wait  = new WebDriverWait(w_driver, Duration.ofSeconds(wait_time));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		System.out.println("element is present now.");
	}

	@Override
	public void wait_for_element_to_present(By by, int waittime) {
		// TODO Auto-generated method stub
		WebDriverWait wait  = new WebDriverWait(w_driver, Duration.ofSeconds(waittime));
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		System.out.println("element is present now.");
	}

}
