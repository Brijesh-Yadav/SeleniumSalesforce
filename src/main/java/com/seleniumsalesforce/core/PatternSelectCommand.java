package com.seleniumsalesforce.core;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.openqa.selenium.WebDriver;
import com.seleniumsalesforce.core.SoftDriver.Click;
import com.seleniumsalesforce.core.SoftDriver.Input;
import com.seleniumsalesforce.core.SoftDriver.Pattern;
import com.seleniumsalesforce.core.SoftDriver.Select;
import com.seleniumsalesforce.core.SoftDriver.Verify;
import com.seleniumsalesforce.object.repo.Checkbox;
import com.seleniumsalesforce.object.repo.Radiobox;
import com.seleniumsalesforce.sftable.TableCheckbox;

public class PatternSelectCommand implements Select, Pattern{

	private WebDriver w_driver ;
	
	PatternSelectCommand(WebDriver w_driver){
		this.w_driver = w_driver;
	}

	public Select select() {
		// TODO Auto-generated method stub
		return new PatternSelectCommand(w_driver);
	}

	public Input input() {
		// TODO Auto-generated method stub
		return new PatternInputCommand(w_driver);
	}

	public Click click() {
		// TODO Auto-generated method stub
		return new PatternClickCommand(w_driver);
	}

	@Override
	public Verify verify() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkbox(String labelname) {
		SFutil sl = new SFutil(w_driver);
		ArrayList<String> repo_ = Checkbox.checkbox_repo(labelname, 1);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, 0);
		LinkedHashMap<String,String> fil_obj_maplist = sl.process_object_evaluation(obj_list);
		sl.perform_click(fil_obj_maplist,1);
	}

	@Override
	public void checkbox(String labelname, int obj_prp_index) {
		SFutil sl = new SFutil(w_driver);
		ArrayList<String> repo_ = Checkbox.checkbox_repo(labelname, obj_prp_index);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, 0);
		LinkedHashMap<String,String> fil_obj_maplist = sl.process_object_evaluation(obj_list);
		sl.perform_click(fil_obj_maplist,obj_prp_index);
	}

	@Override
	public void checkbox(String labelname, int obj_prp_index, int html_str_index) {
		SFutil sl = new SFutil(w_driver);
		ArrayList<String> repo_ = Checkbox.checkbox_repo(labelname, obj_prp_index);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, html_str_index);
		LinkedHashMap<String,String> fil_obj_maplist = sl.process_object_evaluation(obj_list);
		sl.perform_click(fil_obj_maplist,obj_prp_index);
	}

	@Override
	public void raiobox(String labelname) {
		SFutil sl = new SFutil(w_driver);
		ArrayList<String> repo_ = Radiobox.radiobox_repo(labelname, 1);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, 0);
		LinkedHashMap<String,String> fil_obj_maplist = sl.process_object_evaluation(obj_list);
		sl.perform_click(fil_obj_maplist,1);
	}

	@Override
	public void raiobox(String labelname, int obj_prp_index) {
		SFutil sl = new SFutil(w_driver);
		ArrayList<String> repo_ = Radiobox.radiobox_repo(labelname, 1);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, 0);
		LinkedHashMap<String,String> fil_obj_maplist = sl.process_object_evaluation(obj_list);
		sl.perform_click(fil_obj_maplist,obj_prp_index);
		
	}

	@Override
	public void raiobox(String labelname, int obj_prp_index, int html_str_index) {
		SFutil sl = new SFutil(w_driver);
		ArrayList<String> repo_ = Radiobox.radiobox_repo(labelname, 1);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, html_str_index);
		LinkedHashMap<String,String> fil_obj_maplist = sl.process_object_evaluation(obj_list);
		sl.perform_click(fil_obj_maplist,obj_prp_index);
	}

	@Override
	public void dropdown(String labelname, String value) {
		
	}

	@Override
	public void dropdown(String labelname, String value, int obj_prp_index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropdown(String labelname, String value, int obj_prp_index, int html_str_index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lightning_dropdown(String labelname, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lightning_dropdown(String labelname, String value, int obj_prp_index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lightning_dropdown(String labelname, String value, int obj_prp_index, int html_str_index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lightning_dropdown_type(String labelname, String value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lightning_dropdown_type(String labelname, String value, int obj_prp_index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lightning_dropdown_type(String labelname, String value, int obj_prp_index, int html_str_index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ElementFind checkbox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElementFind raiobox() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElementFind dropdown() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElementFind lightning_dropdown() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ElementFind lightning_dropdown_type() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TableCheckbox table_checkbox() {
		// TODO Auto-generated method stub
		return null;
	}


}
