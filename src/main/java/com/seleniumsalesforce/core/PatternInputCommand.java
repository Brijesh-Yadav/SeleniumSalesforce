package com.seleniumsalesforce.core;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import com.seleniumsalesforce.core.SoftDriver.Click;
import com.seleniumsalesforce.core.SoftDriver.Input;
import com.seleniumsalesforce.core.SoftDriver.Pattern;
import com.seleniumsalesforce.core.SoftDriver.Select;
import com.seleniumsalesforce.core.SoftDriver.Verify;
import com.seleniumsalesforce.lex.repo.TextArea;
import com.seleniumsalesforce.lex.repo.TextField;

public class PatternInputCommand implements Pattern, Input{

	private WebDriver w_driver ;
	
	PatternInputCommand(WebDriver w_driver){
		this.w_driver = w_driver;
	}
	
	public Select select() {
		return new PatternSelectCommand(w_driver);
	}

	public Input input() {
		return new PatternInputCommand(w_driver);
	}

	public Click click() {
		return new PatternClickCommand(w_driver);
	}

	@Override
	public void textfield(String label,String value) {
		SFutil sl = new SFutil(w_driver);
		ArrayList<String> repo_ = TextField.textfield_repo(label, 1);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, 0);
		String xpath_ele = sl.return_xpath_input(obj_list, 0);
		sl.enter_condition(xpath_ele, value, 1);
	}

	@Override
	public void textfield(String label,String value, int obj_prp_index) {
		SFutil sl = new SFutil(w_driver);
		ArrayList<String> repo_ = TextField.textfield_repo(label, obj_prp_index);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, 0);
		String xpath_ele = sl.return_xpath_input(obj_list, 0);
		sl.enter_condition(xpath_ele, value, obj_prp_index);
	}

	@Override
	public void textfield(String label,String value, int obj_prp_index, int html_str_index) {
		SFutil sl = new SFutil(w_driver);
		ArrayList<String> repo_ = TextField.textfield_repo(label, obj_prp_index);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, html_str_index);
		String xpath_ele = sl.return_xpath_input(obj_list, html_str_index);
		sl.enter_condition(xpath_ele, value, obj_prp_index);
	}

	@Override
	public void textarea(String label,String value) {
		SFutil sl = new SFutil(w_driver);
		ArrayList<String> repo_ = TextArea.textarea_repo(label, 1);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, 0);
		String xpath_ele = sl.return_xpath_input(obj_list, 0);
		sl.enter_condition(xpath_ele, value, 1);
	}

	@Override
	public void textarea(String label,String value, int obj_prp_index) {
		SFutil sl = new SFutil(w_driver);
		ArrayList<String> repo_ = TextArea.textarea_repo(label, obj_prp_index);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, 0);
		String xpath_ele = sl.return_xpath_input(obj_list, 0);
		sl.enter_condition(xpath_ele, value, obj_prp_index);
	}

	@Override
	public void textarea(String label,String value, int obj_prp_index, int html_str_index) {
		SFutil sl = new SFutil(w_driver);
		ArrayList<String> repo_ = TextArea.textarea_repo(label, obj_prp_index);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, html_str_index);
		String xpath_ele = sl.return_xpath_input(obj_list, html_str_index);
		sl.enter_condition(xpath_ele, value, obj_prp_index);
	}

	@Override
	public void js_texteditor(String label,String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void js_texteditor(String label,String value, int obj_prp_index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void js_texteditor(String label,String value, int obj_prp_index, int html_str_index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Verify verify() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElementFind textfield() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElementFind textarea() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElementFind js_texteditor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Execute tablecell(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Execute tablecell(String text, int obj_prp_index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Execute tablecell(String text, int obj_prp_index, int html_str_index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Execute tablecell(String text, String col_number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Execute tablecell(String text, String col_number, int obj_prp_index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Execute tablecell(String text, String col_number, int obj_prp_index, int html_str_index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Execute tablecell(String text, String col_number, String another_cell) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Execute tablecell(String text, String col_number, String another_cell, int obj_prp_index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Execute tablecell(String text, String col_number, String another_cell, int obj_prp_index,
			int html_str_index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Execute tablecell(String text, String col_number, String another_cell, String col_number2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Execute tablecell(String text, String col_number, String another_cell, String col_number2,
			int obj_prp_index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Execute tablecell(String text, String col_number, String another_cell, String col_number2, int obj_prp_index,
			int html_str_index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UploadFile uploadfile() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iframe iframe() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Windows windows() {
		// TODO Auto-generated method stub
		return null;
	}


}
