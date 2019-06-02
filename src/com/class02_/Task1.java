package com.class02_;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.utilis.CommonMethods;

public class Task1 extends CommonMethods{
   /* Open browser and navigate to OrangeHRM
    *  https://opensource-demo.orangehrmlive.com/
    * OrangeHRM title verification
    * Enter valid UID and PSW and click login
    * Verify user successfully logged in
    */
	
	@BeforeClass
	public void setUp() {
		setUpDriver("chrome", " https://opensource-demo.orangehrmlive.com/");
	}
	
	@Test(priority=1)
	//verify you are at right URL
	public void getTitle() {
		String actualTitle=driver.getTitle();
		String expectedTitle="OrangeHRM";
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Title is verified");
		}else {
			System.out.println("Wrong title");
		}
	}
	
	@Test(priority=2)
	public void login() {
		sendText(driver.findElement(By.cssSelector("input#txtUsername")), "Admin");
		sendText(driver.findElement(By.cssSelector("input#txtPassword")), "admin123");
		click(driver.findElement(By.cssSelector("input#btnLogin")));
	}
	
	@Test(priority=3)
	public void verifyLogin() {
		WebElement img=driver.findElement(By.cssSelector("img[alt='OrangeHRM']"));
		if(img.isDisplayed()) {
			System.out.println("User was successfully logged in");
		}else {
			System.out.println("User was NOT successfully logged in");
		}
	}
	
	@AfterClass
	public void ClosePage() {
		driver.quit();
	}
	
	
	
	
}
