package com.class04_;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider2 {

	@DataProvider
	public Object[][] setUpData(){
		Object[][] data=new Object[3][2];
		//3 sets of data that holds 2 values
		data[0][0]="Tim";
		data[0][1]="Jones";
		
		data[1][0]="Billy";
		data[1][1]="Jones";
		
		data[2][0]="Will";
		data[2][1]="Smith";
		
		return data;
	}
			
	@Test(dataProvider="setUpData")  //equals to method name from @DataProvider
	//we are passing number of values that each sets holds--> 2 String
	public void getData(String first, String last) {
		System.out.println(first+" "+last);
	}
	
	
	
}
