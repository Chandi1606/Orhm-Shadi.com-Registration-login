package com.gqt.testngtestcases;

import org.testng.annotations.DataProvider;

public class OrhmLoginDatas {
	
	@DataProvider(name="LoginProvider")
	public Object[][] LoginProvider(){
		
		Object[][] login=new Object[3][2];
		login[0][0]="Admin";
		login[0][1]="admin123";
		login[1][0]="Manager";
		login[1][1]="manager123";
		login[2][0]="Developer";
		login[2][1]="developer123";
		
		return login;
	
	}

}
