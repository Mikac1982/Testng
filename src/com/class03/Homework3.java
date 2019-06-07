package com.class03;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class Homework3 extends CommonMethods{
  /*OrangeHRM Verify Employee DetailsStep  
	1:Click on PIM link and Employee ListStep 
	2:Search for employee by it idStep 
	3:Verify Employee details are displayed 
   */
	
	@BeforeClass
	public void setUp() {
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test(priority=0)
	public void login() {
		sendText(driver.findElement(By.cssSelector("input#txtUsername")), "Admin");
		sendText(driver.findElement(By.cssSelector("input#txtPassword")), "admin123");
		click(driver.findElement(By.cssSelector("input#btnLogin")));
	}
	
	@Test(priority=1)
	public void searchForEmployee() {
		click(driver.findElement(By.xpath("//b[text()='PIM']")));
		click(driver.findElement(By.xpath("//a[text()='Employee List']")));
		sendText(driver.findElement(By.id("empsearch_id")), "00123");
		click(driver.findElement(By.cssSelector("input#searchBtn")));	
	}
	
	@Test(priority=2)
	public void employeeDetails() {
		boolean link=driver.findElement(By.xpath("//a[text()='00123']")).isDisplayed();
		Assert.assertTrue(link);
		System.out.println("Employee details are displayed ");
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	
}
