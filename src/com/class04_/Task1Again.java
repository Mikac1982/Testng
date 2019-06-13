package com.class04_;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class Task1Again extends CommonMethods{
	/*Identify Priority of Test Cases
	https://www.saucedemo.com/
	TC 1: Saucedemo Username1(tag the groups - Smoke)
	Step 1: Open browser and navigate to Saucedemo
	Step 2: Enter username standard_user and enter password secret_sauce and click login button
	Step 3: Verify user successfully logged in
	
	TC 2: Saucedemo Username2(tag the groups - Regression)
	Step 1: Open browser and navigate to Saucedemo
	Step 2: Enter username problem_user and enter password secret_sauce and click login button
	Step 3: Verify user successfully logged in
	Note: Create BeforeMethod and AfterMethod annotations to open browser and logout from the application.
	Create a xml file and include smoke.
	*/
	
	@BeforeMethod(alwaysRun=true,groups="Regression")
	public void setUp() {
		setUpDriver("chrome", "https://www.saucedemo.com/");
	}

    @Test(groups="Smoke")
    public void userOne() {
    	sendText(driver.findElement(By.id("user-name")), "standard_user");
    	sendText(driver.findElement(By.id("password")), "secret_sauce");
    	click(driver.findElement(By.className("btn_action")));
    	
    	Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Products']")).isDisplayed(),true);
    	System.out.println("User 1 is successfully logged in");
    }

    @Test(groups="Regression")
    public void userTwo() {
    	sendText(driver.findElement(By.id("user-name")), "problem_user");
    	sendText(driver.findElement(By.id("password")), "secret_sauce");
    	click(driver.findElement(By.className("btn_action")));
    	
    	Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Products']")).isDisplayed(),true);
    	System.out.println("User 2 is successfully logged in");
    }

    @AfterMethod(alwaysRun=true,groups="Regression")
	public void tearDown() {
		driver.close();
	}


}
