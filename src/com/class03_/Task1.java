package com.class03_;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class Task1 extends CommonMethods{
	/*  TC1: Saucedemo Username1(tag the groups - Smoke1, Regression1)Step 
	 1: Open browser and navigate to SaucedemoStep 
	 2: Enter username standard_user and enter password secret_sauce and click login buttonStep 
	 3: Verify user successfully logged in
	 
	    TC2: Saucedemo Username2(tag the groups - Smoke2, Regression2)Step 
	 1: Open browser and navigate to SaucedemoStep 
	 2: Enter username problem_user and enter password secret_sauce and click login buttonStep 
	 3: Verify user successfully logged in
	 
	 Note: Create BeforeMethod and AfterMethod annotations to open browser and logout from the application. 
	 Create a xml file and include smoke1, regression2 and exclude smoke2, regression1.
	 */
	
	@BeforeGroups
	public void setUp() {
		setUpDriver("chrome", "https://www.saucedemo.com/");
	}
	
	@Test(groups="Smoke1")
	public void userOne() {
		sendText(driver.findElement(By.cssSelector("input#user-name")), "standard_user");
		sendText(driver.findElement(By.id("password")), "secret_sauce");
		click(driver.findElement(By.cssSelector("input.btn_action")));
	}
	
	@Test(groups="Regression1")
	public void userTwo() {
		sendText(driver.findElement(By.id("user-name")), "problem_user");
		sendText(driver.findElement(By.id("password")), "secret_sauce");
		click(driver.findElement(By.cssSelector("input.btn_action")));
	}
	
	@Test(groups="Regression2")
	public void userThree() {
		sendText(driver.findElement(By.cssSelector("input#user-name")), "performance_glitch_user");
		sendText(driver.findElement(By.cssSelector("input.form_input")), "secret_sauce");
		click(driver.findElement(By.cssSelector("input.btn_action")));
	}
	
	@BeforeGroups
	public void tearDown() {
		driver.close();
	}
	
}
