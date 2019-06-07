package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class Homework2 extends CommonMethods{
	/*OrangeHRM Add EmployeeStep 
	1: Click on PIM link and Add EmployeeStep 
	2: Provide Details and SaveStep 
	3: Verify Employee is added 
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
	public void addEmployee() {
		click(driver.findElement(By.xpath("//b[text()='PIM']")));
		click(driver.findElement(By.cssSelector("input[name='btnAdd']")));
	}
	
	@Test(priority=2)
	public void provideDetails() throws InterruptedException {
		sendText(driver.findElement(By.id("firstName")), "Alex");
		sendText(driver.findElement(By.id("lastName")), "Adams");
		sendText(driver.findElement(By.id("employeeId")), "00128");
		
		String filePath="/Users/milenasibalic/Downloads/cats.jpg";
		sendText(driver.findElement(By.id("photofile")),filePath);
		Thread.sleep(2000);
		
	//	click(driver.findElement(By.id("chkLogin")));
	//	sendText(driver.findElement(By.id("user_name")), "jackadams");
	//	sendText(driver.findElement(By.id("user_password")), "***pass123");
	//	sendText(driver.findElement(By.id("re_password")), "***pass123");
	//	Thread.sleep(2000);
	//	WebElement status=driver.findElement(By.id("status"));
	//	selectValueFromDD(status, "Enabled");
	//	Thread.sleep(2000);
		click(driver.findElement(By.id("btnSave")));
		Thread.sleep(4000);
	    }
		
		@Test(priority=3)
		public void verifyEmployee() {
			boolean img=driver.findElement(By.cssSelector("img[alt='Employee Photo']")).isDisplayed();
			Assert.assertTrue(img);
		    System.out.println("Employee is successfully added");
		}
		
		@AfterClass
		public void tearDown() {
			driver.quit();
		}
	
	
	
	
	
}
