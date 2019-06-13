package com.class04_;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class ToolsQaExample extends CommonMethods{

	@BeforeMethod(alwaysRun=true)
	public void setUp() {
		setUpDriver("chrome","https://www.toolsqa.com/automation-practice-form/");
	}
	
	@DataProvider()
	//method to store data -location of dataProvider
	public Object[][] setUpData(){
		//4 people with 3 sets of data
		Object [][] data=new Object[4][3];
		
		data[0][0]="first1";
		data[0][1]="last1";
		data[0][2]="00-00-0000";
		
		data[1][0]="first2";
		data[1][1]="last2";
		data[1][2]="00-01-0000";
		
		data[2][0]="first3";
		data[2][1]="last3";
		data[2][2]="00-02-0000";
		
		data[3][0]="first4";
		data[3][1]="last4";
		data[3][2]="00-03-0000";

		return data;
	}
	
	//method to retrieve data 
	@Test(dataProvider="setUpData")
	public void getData(String first, String last, String date) {
		sendText(driver.findElement(By.cssSelector("input[name='firstname']")),first);
		sendText(driver.findElement(By.cssSelector("input[name='lastname']")),last);
		sendText(driver.findElement(By.id("datepicker")),date);
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.close();
	}
	
}
