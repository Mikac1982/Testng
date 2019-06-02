package com.class02;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class Task1 extends CommonMethods{
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
	public void verification() {
		String title=driver.getTitle();
		String expectedTitle="OrangeHRM";
		System.out.println(title);
		
		if(title.equals(expectedTitle)) {
			System.out.println("This is the right title");
		}else {
			System.out.println("This is the wrong title");
		}
	}
	
	@Test(priority=0)
	public void login() throws InterruptedException {
		sendText(driver.findElement(By.cssSelector("input#txtUsername")), "Admin");
		Thread.sleep(2000);
		sendText(driver.findElement(By.cssSelector("input#txtPassword")), "admin123");
		Thread.sleep(2000);
		click(driver.findElement(By.cssSelector("input#btnLogin")));
	
	}
	
	@AfterClass
	public void close() {
		driver.close();
	}
	
	
	
	
	
	
}
