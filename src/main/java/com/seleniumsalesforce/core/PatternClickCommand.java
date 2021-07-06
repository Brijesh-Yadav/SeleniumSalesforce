package com.seleniumsalesforce.core;

import java.util.ArrayList;
import java.util.HashMap;
import org.openqa.selenium.WebDriver;
import com.seleniumsalesforce.core.SoftDriver.Click;
import com.seleniumsalesforce.core.SoftDriver.Input;
import com.seleniumsalesforce.core.SoftDriver.Pattern;
import com.seleniumsalesforce.core.SoftDriver.Select;
import com.seleniumsalesforce.core.SoftDriver.Verify;
import com.seleniumsalesforce.object.repo.Button;
import com.seleniumsalesforce.object.repo.Link;
import com.seleniumsalesforce.object.repo.TextArea;
import com.seleniumsalesforce.object.repo.TextField;

public class PatternClickCommand implements Click, Pattern{
	
	private WebDriver w_driver ;
	PatternClickCommand(WebDriver w_driver){
		this.w_driver = w_driver;
	}

	public Click click() {
		return new PatternClickCommand(w_driver);
	}
	
	public Select select() {
		return new PatternSelectCommand(w_driver);
	}

	public Input input() {
		return new PatternInputCommand(w_driver);
	}
	
	public void button(String label) {
		SFutil sl = new SFutil(w_driver);
		Button bt = new Button();
		ArrayList<String> repo_ = bt.button_repo(label, 1);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, 0);
		HashMap<String,String> fil_obj_maplist = sl.process_object_evaluation(obj_list);
		sl.perform_click(fil_obj_maplist,1);
	}

	public void button(String text, int obj_prp_index) {
		SFutil sl = new SFutil(w_driver);
		Button bt = new Button();
		ArrayList<String> repo_ = bt.button_repo(text, obj_prp_index);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, 0);
		HashMap<String,String> fil_obj_maplist = sl.process_object_evaluation(obj_list);
		sl.perform_click(fil_obj_maplist,obj_prp_index);
	}
	
	public void button(String text, int obj_prp_index, int html_str_index) {
		SFutil sl = new SFutil(w_driver);
		Button bt = new Button();
		ArrayList<String> repo_ = bt.button_repo(text, obj_prp_index);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, html_str_index);
		HashMap<String,String> fil_obj_maplist = sl.process_object_evaluation(obj_list);
		sl.perform_click(fil_obj_maplist,obj_prp_index);
	}
	
	public void link(String label) {
		SFutil sl = new SFutil(w_driver);
		Link ln = new Link();
		ArrayList<String> repo_ = ln.link_repo(label, 1);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, 0);
		HashMap<String,String> fil_obj_maplist = sl.process_object_evaluation(obj_list);
		sl.perform_click(fil_obj_maplist,1);
	}

	public void textarea(String label) {
		SFutil sl = new SFutil(w_driver);
		TextArea ta = new TextArea();
		ArrayList<String> repo_ = ta.textarea_repo(label, 1);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, 0);
		HashMap<String,String> fil_obj_maplist = sl.process_object_evaluation(obj_list);
		sl.perform_click(fil_obj_maplist,1);
	}
	
	public void textfield(String label) {
		SFutil sl = new SFutil(w_driver);
		TextField tf = new TextField();
		ArrayList<String> repo_ = tf.textfield_repo(label, 1);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, 0);
		HashMap<String,String> fil_obj_maplist = sl.process_object_evaluation(obj_list);
		sl.perform_click(fil_obj_maplist,1);
	}

	public ElementFind button() {
		// TODO Auto-generated method stub
		return new ElementFind(w_driver);
	}

	@Override
	public void textfield(String text, int obj_prp_index) {
		SFutil sl = new SFutil(w_driver);
		TextField tf = new TextField();
		ArrayList<String> repo_ = tf.textfield_repo(text, obj_prp_index);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, 0);
		HashMap<String,String> fil_obj_maplist = sl.process_object_evaluation(obj_list);
		sl.perform_click(fil_obj_maplist,obj_prp_index);
	}

	@Override
	public void textfield(String text, int obj_prp_index, int html_str_index) {
		SFutil sl = new SFutil(w_driver);
		TextField tf = new TextField();
		ArrayList<String> repo_ = tf.textfield_repo(text, obj_prp_index);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, html_str_index);
		HashMap<String,String> fil_obj_maplist = sl.process_object_evaluation(obj_list);
		sl.perform_click(fil_obj_maplist,obj_prp_index);
	}

	@Override
	public void link(String text, int obj_prp_index) {
		SFutil sl = new SFutil(w_driver);
		Link ln = new Link();
		ArrayList<String> repo_ = ln.link_repo(text, obj_prp_index);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, 0);
		HashMap<String,String> fil_obj_maplist = sl.process_object_evaluation(obj_list);
		sl.perform_click(fil_obj_maplist,obj_prp_index);
	}

	@Override
	public void link(String text, int obj_prp_index, int html_str_index) {
		SFutil sl = new SFutil(w_driver);
		Link ln = new Link();
		ArrayList<String> repo_ = ln.link_repo(text, obj_prp_index);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, html_str_index);
		HashMap<String,String> fil_obj_maplist = sl.process_object_evaluation(obj_list);
		sl.perform_click(fil_obj_maplist,obj_prp_index);
	}

	@Override
	public void textarea(String text, int obj_prp_index) {
		SFutil sl = new SFutil(w_driver);
		TextArea ta = new TextArea();
		ArrayList<String> repo_ = ta.textarea_repo(text, obj_prp_index);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, 0);
		HashMap<String,String> fil_obj_maplist = sl.process_object_evaluation(obj_list);
		sl.perform_click(fil_obj_maplist,obj_prp_index);
	}

	@Override
	public void textarea(String text, int obj_prp_index, int html_str_index) {
		SFutil sl = new SFutil(w_driver);
		TextArea ta = new TextArea();
		ArrayList<String> repo_ = ta.textarea_repo(text, obj_prp_index);
		ArrayList<String> obj_list = sl.process_multiple_object_check(repo_, html_str_index);
		HashMap<String,String> fil_obj_maplist = sl.process_object_evaluation(obj_list);
		sl.perform_click(fil_obj_maplist,obj_prp_index);
	}

	@Override
	public Table table() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Verify verify() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Webelement Webelement() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
