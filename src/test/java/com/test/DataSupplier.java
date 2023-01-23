package com.test;

import org.testng.annotations.DataProvider;

/* this is DataProvider class*/

public class DataSupplier {

	
	@DataProvider
	public String[] dp1() {
		
		String[] data = new String[] {
				
			"abc",
			"xyz",
			"Hardik"
		};
		return data;
	}
	
	
	
}
