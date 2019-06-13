package com.class05_;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class SauceDemo extends CommonMethods{

	@BeforeMethod
	public void setUp() {
		setUpDriver("chrome", "https://www.saucedemo.com/");
	}
	
	@DataProvider(name="sauceData")
	@Test
	public Object[][] setUpData(){
		Object[][] data=new Object[3][2];
		
		data[0][0]="standard_user";
		data[0][1]="secret_sauce";
		
	//	data[1][0]="locked_out_user";
	//	data[1][1]="secret_sauce";
		
		data[1][0]="problem_user";
		data[1][1]="secret_sauce";
		
		data[2][0]="performance_glitch_user";
		data[2][1]="secret_sauce";
		
		return data;
	}
	
	@Test(dataProvider="sauceData")
	public void testUsers(String username, String password) {
		
	sendText(driver.findElement(By.id("user-name")), username);	
	sendText(driver.findElement(By.id("password")), password);	
	click(driver.findElement(By.cssSelector("input.btn_action")));
		
	Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Products']")).isDisplayed());
	System.out.println("User: "+username+" successfull logged in");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	
}
