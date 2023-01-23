package com.test;




import org.testng.annotations.Test;

public class BasicDataProviderTest {
	
	
	//this is test method for  dataprovider  data that you are getting from dataSupplier class
	
	@Test(dataProvider ="dp1",dataProviderClass = DataSupplier.class)
	public void testDpdata(String s) {
		
		System.out.println(s);
		
	}
	
	
	

}
