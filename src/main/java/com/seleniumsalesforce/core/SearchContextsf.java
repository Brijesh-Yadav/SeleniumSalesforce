package com.seleniumsalesforce.core;

import com.seleniumsalesforce.core.SoftDriver.Click;
import com.seleniumsalesforce.core.SoftDriver.Input;
import com.seleniumsalesforce.core.SoftDriver.Select;
import com.seleniumsalesforce.core.SoftDriver.Verify;

public interface SearchContextsf {
	
	Click click();
	Select select();
	Input input();
	Verify verify();
	UploadFile uploadfile();
	Iframe iframe();
	Windows windows();
	
	interface UploadFile{
		
		void uploadfile();
	}
	
	interface Iframe{
		
		void iframe();
	}
	
	interface Windows{
		
		void windows();
	}
}

