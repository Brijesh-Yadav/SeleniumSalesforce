package com.seleniumsalesforce.sftable;

import com.seleniumsalesforce.core.Execute;

public interface TableRadiobox {
	
	Execute tablecell(String text);
	Execute tablecell(String text,int obj_prp_index);
	Execute tablecell(String text,int obj_prp_index,int html_str_index);

	Execute tablecell(String text, String col_number);
	Execute tablecell(String text, String col_number,int obj_prp_index);
	Execute tablecell(String text, String col_number,int obj_prp_index,int html_str_index);

	Execute tablecell(String text, String col_number, String another_cell);
	Execute tablecell(String text, String col_number,String another_cell,int obj_prp_index);
	Execute tablecell(String text, String col_number,String another_cell,int obj_prp_index,int html_str_index);

	Execute tablecell(String text, String col_number, String another_cell,String col_number2);
	Execute tablecell(String text, String col_number,String another_cell,String col_number2,int obj_prp_index);
	Execute tablecell(String text, String col_number,String another_cell,String col_number2,int obj_prp_index,int html_str_index);

	
}
