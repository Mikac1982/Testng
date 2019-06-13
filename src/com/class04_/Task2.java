package com.class04_;

import org.openqa.selenium.By;
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
	@BeforeMethod(alwaysRun=true)
	public void setUp(String browser, String url) {
		setUpDriver(browser, url);
	}
	
	@Parameters({"userName1", "password"})
	@Test
	public void userOne(String user1, String pass) {
		sendText(driver.findElement(By.id("user-name")), user1);
		sendText(driver.findElement(By.id("password")), pass);
		click(driver.findElement(By.className("btn_action")));
	}
	
	@Parameters({"userName2", "password"})
	@Test
	public void userTwo(String user2, String pass) {
		sendText(driver.findElement(By.id("user-name")), user2);
		sendText(driver.findElement(By.id("password")), pass);
		click(driver.findElement(By.className("btn_action")));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
}
