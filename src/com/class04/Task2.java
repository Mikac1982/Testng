package com.class04;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class Task2 extends CommonMethods{
	/*TC 1: Saucedemo Username1(parameters - username and password)
	Step 1: Open browser and navigate to Saucedemo
	Step 2: Enter username standard_user and enter password secret_sauce and click login button
	Step 3: Verify user successfully logged in

	TC 2: Saucedemo Username2(parameters - username and password)
	Step 1: Open browser and navigate to Saucedemo
	Step 2: Enter username problem_user and enter password secret_sauce and click login button
	Step 3: Verify user successfully logged in


	Note: Create BeforeMethod and AfterMethod annotations to open browser and logout from the application. 
	Create a xml file with parameters username and password .
	*/
	
	@Parameters({"browser", "url"})
	@BeforeMethod
	public void setUp(String chrome, String url) {
	    
	    setUpDriver(chrome, url);
    }
	
	@Parameters({"username1", "password"})
	@Test
	public void UserOne(String username1, String password) {
	    
	  sendText(driver.findElement(By.id("user-name")), username1);
	  sendText(driver.findElement(By.id("password")), password);
	  driver.findElement(By.className("btn_action")).click();
	  Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Products']")).isDisplayed(), true);
	}
	
	@Parameters({"username2", "password"})
	@Test
	public void UserTwo(String username2, String password) {
	    
	       sendText(driver.findElement(By.id("user-name")), username2);
	       sendText(driver.findElement(By.id("password")), password);
	       driver.findElement(By.className("btn_action")).click();
	       Assert.assertEquals(driver.findElement(By.xpath("//div[text()='Products']")).isDisplayed(), true);
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
}
