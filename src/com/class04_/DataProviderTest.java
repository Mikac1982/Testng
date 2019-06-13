package com.class04_;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@DataProvider
	//method where we store data; has return
	public Object [][] setUpData(){
		Object [][] data=new Object[3][2]; //3 sets of data/Objects that holds 2 values
		
		data[0][0]="Tim";
		data[0][1]="Jones";
		
		data[1][0]="Billy";
		data[1][1]="Jones";
		
		data[2][0]="Will";
		data[2][1]="Smith";
		
		return data;
	}
	
	//to retrieve data
	//dataProvider=name of data provider method name 
	@Test(dataProvider="setUpData")
	public void getData(String first, String last) {
		
		System.out.println(first+" "+last);
		
	}
	
	
	
	
	
}
