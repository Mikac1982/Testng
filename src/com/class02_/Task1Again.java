package com.class02_;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class Task1Again extends CommonMethods {
   /*TC 1: OrangeHRM Title Validation
     TC 2: OrangeHRM Successful Login 
     https://opensource-demo.orangehrmlive.com/
     Please make sure to use the following:
     annotations:
	 @BeforeMethod
	 @AfterMethod
	 @Test
    What would you do if you do not want to execute any specific test case?
    What would you do if you want to execute any specific test case first?
   */
	
	@BeforeClass
	public void setUp() {
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test(priority=1)
	public void validation() {
		
		String title=driver.getTitle();
		System.out.println(title);
		String expectedTitle="OrangeHRM";
		if(title.equals(expectedTitle)) {
			System.out.println("This is right title");
		}else {
			System.out.println("This is wrong title");
		}
	}
	
	@Test(priority=2)
	public void login() {
		sendText(driver.findElement(By.cssSelector("input#txtUsername")),"Admin");
		sendText(driver.findElement(By.cssSelector("input#txtPassword")),"admin123");
		click(driver.findElement(By.id("btnLogin")));
	
	}
	
	@Test(priority=3)
	public void verifyLogin() {
	WebElement dashboard=driver.findElement(By.xpath("//h1[text()='Dashboard']"));	
	String expected="Dashboard"	;
	if(dashboard.isDisplayed()) {
		System.out.println("Successfully logged in");
	}else {
		System.out.println("Not successfully logged in");
	}
	}
	
	@AfterClass
	public void close() {
		driver.quit();
	}
	
	
	
}
